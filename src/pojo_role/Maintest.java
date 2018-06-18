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
		// Team bob = new Team(new Admin(), "bob", "bobby", "bob@mail.com");
		// Categorie cat = new Categorie(1, "code source");
		// System.out.println();
		// Article a = new Article("encore un article dans code source et moins vieux",
		// bob, cat);
		// ArticleDAO.singleton().create(a);
		//
		// System.out.println("nb de résultats : " + ArticleDAO.singleton().find(new
		// StringBuffer("bobby")));
		// List li = ArticleDAO.singleton().get_recherche();
		// for(int i =0; i< li.size(); i++) {
		// System.out.println(li.get(i).toString());
		// }
		 List lu = ArticleDAO.singleton().importation();
		 for(int i =0; i< lu.size(); i++) {
			 System.out.println(lu.get(i).toString());
			 }
	}

}
