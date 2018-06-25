-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 25 juin 2018 à 09:01
-- Version du serveur :  5.7.19-log
-- Version de PHP :  7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cms`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `titre` varchar(155) NOT NULL,
  `resume` varchar(255) DEFAULT NULL,
  `contenu` text,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `auteur` varchar(45) NOT NULL,
  `categorie` varchar(255) NOT NULL,
  `visible` tinyint(4) NOT NULL DEFAULT '0',
  `commentaire` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`titre`),
  KEY `author_idx` (`auteur`),
  KEY `categorie_idx` (`categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`titre`, `resume`, `contenu`, `date`, `auteur`, `categorie`, `visible`, `commentaire`) VALUES
('hello world', 'affiche un hello world en java', 'voici un hello world en java les noobs : <BR>public static void hellolesnoobs <BR>{System.out.println(\"hello\");<BR>}', '2018-06-18 06:35:19', 'bobby', 'code source', 0, 0),
('un autre article plus solide', NULL, NULL, '2018-06-18 13:06:48', 'bobby', 'code source', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `cat`
--

DROP TABLE IF EXISTS `cat`;
CREATE TABLE IF NOT EXISTS `cat` (
  `titre` varchar(255) NOT NULL,
  `ordre` int(11) NOT NULL,
  PRIMARY KEY (`titre`),
  UNIQUE KEY `titre_UNIQUE` (`titre`),
  UNIQUE KEY `ordre_UNIQUE` (`titre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `cat`
--

INSERT INTO `cat` (`titre`, `ordre`) VALUES
('cattest', 2),
('code source', 1);

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contenu` text NOT NULL,
  `visiteur` varchar(55) NOT NULL,
  `article` varchar(155) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `mod` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `visit_idx` (`visiteur`),
  KEY `article_idx` (`article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `param`
--

DROP TABLE IF EXISTS `param`;
CREATE TABLE IF NOT EXISTS `param` (
  `nom` varchar(255) NOT NULL,
  `description` text,
  `theme` varchar(45) NOT NULL,
  PRIMARY KEY (`nom`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `param`
--

INSERT INTO `param` (`nom`, `description`, `theme`) VALUES
('le blog de bob', 'bob poste ses fameux codes sources', 'bobtheme');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `watrole` int(1) NOT NULL,
  `nom` varchar(45) NOT NULL,
  PRIMARY KEY (`watrole`),
  UNIQUE KEY `nom_UNIQUE` (`nom`),
  UNIQUE KEY `watrole_UNIQUE` (`watrole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`watrole`, `nom`) VALUES
(1, 'admin'),
(3, 'moderateur'),
(2, 'writer');

-- --------------------------------------------------------

--
-- Structure de la table `team`
--

DROP TABLE IF EXISTS `team`;
CREATE TABLE IF NOT EXISTS `team` (
  `nom` varchar(100) NOT NULL,
  `pseudo` varchar(45) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `role` int(1) NOT NULL,
  PRIMARY KEY (`pseudo`),
  UNIQUE KEY `pseudo_UNIQUE` (`pseudo`),
  KEY `roles_idx` (`role`),
  KEY `pseudo` (`pseudo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `team`
--

INSERT INTO `team` (`nom`, `pseudo`, `mail`, `role`) VALUES
('bob', 'bobby', 'bob@mail.com', 1);

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

DROP TABLE IF EXISTS `visiteur`;
CREATE TABLE IF NOT EXISTS `visiteur` (
  `pseudo` varchar(55) NOT NULL,
  `mail` varchar(155) NOT NULL,
  PRIMARY KEY (`pseudo`),
  UNIQUE KEY `pseudo_UNIQUE` (`pseudo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `author` FOREIGN KEY (`auteur`) REFERENCES `team` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `categorie` FOREIGN KEY (`categorie`) REFERENCES `cat` (`titre`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD CONSTRAINT `article` FOREIGN KEY (`article`) REFERENCES `article` (`titre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `visit` FOREIGN KEY (`visiteur`) REFERENCES `visiteur` (`pseudo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `team`
--
ALTER TABLE `team`
  ADD CONSTRAINT `roles` FOREIGN KEY (`role`) REFERENCES `role` (`watrole`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
