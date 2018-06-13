package dao;

import java.util.ArrayList;

import bdd.DAOmanager;
import pojo.Categorie;

public class CategorieDAO extends DAOmanager<Categorie>{
	private static CategorieDAO cat = new CategorieDAO();
	
	private CategorieDAO() {
		
	}
	public static CategorieDAO singleton() {
		return cat;
	}
	
	@Override
	public StringBuffer find(StringBuffer strb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie create(Categorie obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie update(Categorie obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Categorie obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Categorie> importation() {
		// TODO Auto-generated method stub
		return null;
	}

}
