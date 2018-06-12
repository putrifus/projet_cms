package dao;

import java.util.ArrayList;

import bdd.DAOmanager;
import pojo.Article;

public class ArticleDAO extends DAOmanager<Article>{
	private static ArticleDAO art = new ArticleDAO();
	private ArrayList<Article> list = new ArrayList<Article>();
	
	public static ArticleDAO ArticleDAOsingleton() {
		return art;
	}

	@Override
	public StringBuffer find(StringBuffer strb) {
		//recherche un article dans la base
		return null;
	}

	@Override
	public Article create() {
		//créer un nouvel article non visible et non commentable 
		return null;
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
		return null;
	}
	
	
}
