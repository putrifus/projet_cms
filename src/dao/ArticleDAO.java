package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.DAOmanager;
import pojo.Article;

public class ArticleDAO extends DAOmanager<Article> {
	private static ArticleDAO art = new ArticleDAO();
	private ArrayList<Article> list = new ArrayList<Article>();
	private ArrayList<Article> recherche = new ArrayList<Article>();

	public static ArticleDAO singleton() {
		return art;
	}

	@Override
	public StringBuffer find(StringBuffer strb) {
		// recherche un article dans la base
		if (recherche.isEmpty()) {

			StringBuffer out = new StringBuffer();
			int ctp = 0;
			try {
				ResultSet result = this.connect
						.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
						.executeQuery("SELECT * FROM cms.article");
			} catch (SQLException e) {
				System.out.println("error sql find");
			}
			out.append(ctp);
			return out;
		} else {
			recherche.clear();
			find(strb);
			return null;
		}
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

				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Article update(Article obj) {
		// TODO rend commentable ou non un article en bdd
		return null;
	}

	@Override
	public void delete(Article obj) {
		// rend invisible ou non l'article en bdd

	}

	@Override
	public ArrayList<Article> importation() {
		// import en list les articles en bdd
		return list;
	}

}
