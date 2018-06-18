package pojo_role;

import java.util.ArrayList;
import java.util.List;

import dao.ArticleDAO;
import pojo.Article;
import pojo.Categorie;
import pojo.Team;

public class Maintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Team toto = new Team(new Admin(), "toto", "toto", "totomail");
		// Categorie cat = new Categorie(1, "cattest");
		// System.out.println();
		// Article a = new Article("le titre a test", toto, cat);
		 System.out.println("nb de résultats : " + ArticleDAO.singleton().find(new
		 StringBuffer("hello")));
		 List li = ArticleDAO.singleton().get_recherche();
		 for(int i =0; i< li.size(); i++) {
		 System.out.println(li.get(i).toString());
		 }
	}

}
