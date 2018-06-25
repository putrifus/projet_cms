package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.DAOmanager;
import pojo.Article;
import pojo.Categorie;
import pojo.Commentaire;
import pojo.Visiteur;

public class CommentaireDAO extends DAOmanager<Commentaire> {
	private static CommentaireDAO com = new CommentaireDAO();
	private ArrayList<Commentaire> list = new ArrayList<Commentaire>();
	private ArrayList<Commentaire> recherche = new ArrayList<Commentaire>();

	private CommentaireDAO() {
	}

	public static CommentaireDAO singleton() {
		return com;
	}

	@Override
	public StringBuffer find(StringBuffer strb) {
		// TODO Auto-generated method stub
		if (!(recherche.isEmpty())) {
			recherche.clear();
		}
		StringBuffer out = new StringBuffer();
		int ctp = 0;

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM cms.commentaire where article = '" + strb + "' ORDER BY date DESC");

			if (!(result.next())) {
				System.out.println("pas de comm ici");
				return null;
			}

			while (result.next()) {
				Commentaire com = new Commentaire(++ctp, result.getString(2), result.getTimestamp(5).toLocalDateTime(),
						result.getBoolean(6), new Visiteur(result.getString(3)), new Article(strb.toString()));

				recherche.add(com);
			}

		} catch (SQLException e) {
			System.out.println("error sql find");
		}
		out.append(ctp);
		return out;
	}

	@Override
	public Commentaire create(Commentaire obj) {
		// TODO Auto-generated method stub
		try {

			PreparedStatement prepare = this.connect
					.prepareStatement("INSERT INTO cms.commentaire VALUES(default, ?, ?, ?, ?, ?)");

			prepare.setString(2, obj.get_contenu());
			prepare.setString(3, obj.get_auteur().toString());
			prepare.setString(4, obj.get_article().get_titre());
			prepare.setTimestamp(5, time);
			prepare.setBoolean(6, false);
			prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Commentaire update(Commentaire obj) {
		// modère un comm en passant a true _mod
		try {
			PreparedStatement sm = this.connect
					.prepareStatement("UPDATE cms.commentaire SET mod = 1 where id = '" + obj.get_id() + "'");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public void delete(Commentaire obj) {
		// supprime les comm modérés de la base, definitivement
		try {
			PreparedStatement del = this.connect.prepareStatement("DELETE FROM cms.commentaire WHERE mod > 0");

			del.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Commentaire> importation() {
		// import des commentaires de la base pour traitement admin
		if (!(list.isEmpty())) {
			list.clear();
		}

		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM cms.commentaire");

			if (!(result.next())) {
				System.out.println("pas de comm ici");
				return null;
			}

			while (result.next()) {
				Commentaire com = new Commentaire(result.getInt(1), result.getString(2), result.getTimestamp(5).toLocalDateTime(),
						result.getBoolean(6), new Visiteur(result.getString(3)), new Article(result.getString(4)));

				list.add(com);
			}

		} catch (SQLException e) {
			System.out.println("error sql importation");
		}
		return list;
	}

}
