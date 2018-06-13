package pojo_role;

import dao.ArticleDAO;
import pojo.Article;
import pojo.Categorie;
import pojo.Team;

public class Maintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Team toto = new Team(new Admin(), "toto", "toto", "totomail");
		Categorie cat = new Categorie(1, "cattest");
		System.out.println();
		Article a = new Article("le titre a test", toto, cat);
		ArticleDAO.singleton().create(a);
	}

}
