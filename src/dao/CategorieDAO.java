package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.DAOmanager;
import pojo.Categorie;

public class CategorieDAO extends DAOmanager<Categorie> {
	private static CategorieDAO cat = new CategorieDAO();
	private ArrayList<Categorie> list = new ArrayList<Categorie>();
	private ArrayList<Categorie> recherche = new ArrayList<Categorie>();

	private CategorieDAO() {
	}

	public static CategorieDAO singleton() {
		return cat;
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
					.executeQuery("SELECT * FROM cms.categorie where titre LIKE '%" + strb + "%' ORDER BY ordre ASC");

			while (result.next()) {
				ctp++;
				Categorie cat = new Categorie(result.getInt(2), result.getString(1));

				recherche.add(cat);
			}

		} catch (SQLException e) {
			System.out.println("error sql find");
		}
		out.append(ctp);
		return out;
	}

	public ArrayList<Categorie> get_recherche() {
		return this.recherche;
	}

	@Override
	public Categorie create(Categorie obj) {
		// TODO Auto-generated method stub
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT titre FROM cms.categorie where titre = '" + obj.get_titre() + "'");

			if (result.next()) {
				System.out.println("titre existant");
				return null;
			} else {
				PreparedStatement prepare = this.connect
						.prepareStatement("INSERT INTO cms.categorie VALUES(?, default)");

				prepare.setString(1, obj.get_titre());
				prepare.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Categorie update(Categorie obj) {
		// ????
		return null;
	}

	@Override
	public void delete(Categorie obj) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement del = this.connect
					.prepareStatement("DELETE FROM cms.categorie WHERE titre = '" + obj.get_titre() + "'");

			del.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Categorie> importation() {
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM cms.categorie ORDER BY ordre ASC");

			while (result.next()) {
				Categorie resultat = new Categorie(result.getInt(2), result.getString(1));
				list.add(resultat);
			}
		} catch (SQLException e) {
			System.out.println("error sql import");
		}
		return list;
	}

}
