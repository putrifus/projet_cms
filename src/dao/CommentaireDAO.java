package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.DAOmanager;
import pojo.Categorie;
import pojo.Commentaire;

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
				ctp++;
				Commentaire com = new Commentaire();

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
		return null;
	}

	@Override
	public Commentaire update(Commentaire obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Commentaire obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Commentaire> importation() {
		// import des commentaires de l'article
		return null;
	}

}
