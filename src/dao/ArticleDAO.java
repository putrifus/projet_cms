package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bdd.DAOmanager;
import pojo.Article;
import pojo.Categorie;
import pojo.Team;
import pojo_role.Role;
import pojo_role.Writer;

public class ArticleDAO extends DAOmanager<Article> {
	private static ArticleDAO art = new ArticleDAO();
	private ArrayList<Article> list = new ArrayList<Article>();
	private ArrayList<Article> recherche = new ArrayList<Article>();

	public static ArticleDAO singleton() {
		return art;
	}

	@Override
	public StringBuffer find(StringBuffer strb) {
		// recherche article(s) dans la base en fonction de son titre, contenu ou résumé
		// (trié par date) et l'ajoute dans un arraylist
		if (!(recherche.isEmpty())) {
			recherche.clear();
		}

		StringBuffer out = new StringBuffer();
		int ctp = 0;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM cms.article where (titre || resume || contenu LIKE '%" + strb
							+ "%' || auteur = '" + strb + "') ORDER BY date DESC");
			while (result.next()) {
				ctp++;
				Article resultat = new Article(result.getString(1), result.getString(2), result.getString(3),
						new Team(result.getString(5)), new Categorie(result.getString(6)), result.getBoolean(7),
						result.getBoolean(8), result.getTimestamp(4).toLocalDateTime());
				recherche.add(resultat);
			}

		} catch (SQLException e) {
			System.out.println("error sql find");
		}
		out.append(ctp);
		return out;
	}

	public ArrayList<Article> get_recherche() {
		return this.recherche;
	}

	@Override
	public Article create(Article obj) {
		// créer un nouvel article non visible et non commentable
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT titre FROM cms.article where titre = '" + obj.get_titre() + "'");
			if (result.next()) {
				System.out.println("titre existant");
				return null;
			} else {
				PreparedStatement prepare = this.connect
						.prepareStatement("INSERT INTO cms.article VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
				prepare.setString(1, obj.get_titre());
				prepare.setString(2, obj.get_resume());
				prepare.setString(3, obj.get_contenu());
				prepare.setTimestamp(4, time);
				prepare.setString(5, obj.get_writer().toString());
				prepare.setString(6, obj.get_cat().toString());
				prepare.setBoolean(7, obj.is_visible());
				prepare.setBoolean(8, obj.is_comm());
				prepare.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Article update(Article obj) {
		// rend commentable ou non un article en bdd
		try {
			ResultSet result = this.connect.createStatement()
					.executeQuery("SELECT titre FROM cms.article where titre = '" + obj.get_titre() + "'");
			if (!(result.next())) {
				System.out.println("erreur article");
				return null;
			} else {
				PreparedStatement sm = this.connect
						.prepareStatement("UPDATE cms.article SET commentaire = ?");
				sm.setBoolean(1, obj.is_comm());
				sm.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;

	}

	@Override
	public void delete(Article obj) {
		// TODO rend invisible ou non l'article en bdd

	}

	public void force_delete(Article obj) {
		// efface un article de la bdd définitivement!
	}

	@Override
	public ArrayList<Article> importation() {
		// TODO import en list les articles en bdd
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM cms.article ORDER BY date DESC");
			while (result.next()) {
				Article resultat = new Article(result.getString(1), result.getString(2), result.getString(3),
						new Team(result.getString(5)), new Categorie(result.getString(6)), result.getBoolean(7),
						result.getBoolean(8), result.getTimestamp(4).toLocalDateTime());
				list.add(resultat);
			}

		} catch (SQLException e) {
			System.out.println("error sql import");
		}
		return list;
	}

}
