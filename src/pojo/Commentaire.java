package pojo;

import java.time.LocalDateTime;

public class Commentaire {
	private int _id;
	private String _contenu;
	private LocalDateTime _date;
	private boolean _mod;
	private Visiteur _auteur;
	private Article _article;
	
	

	public Commentaire(int _id, String _contenu, LocalDateTime _date, boolean _mod, Visiteur _auteur,
			Article _article) {
		super();
		this._id = _id;
		this._contenu = _contenu;
		this._date = _date;
		this._mod = _mod;
		this._auteur = _auteur;
		this._article = _article;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_contenu() {
		return _contenu;
	}

	public void set_contenu(String _contenu) {
		this._contenu = _contenu;
	}

	public LocalDateTime get_date() {
		return _date;
	}

	public void set_date(LocalDateTime _date) {
		this._date = _date;
	}

	public boolean is_mod() {
		return _mod;
	}

	public void set_mod(boolean _mod) {
		this._mod = _mod;
	}

	public Visiteur get_auteur() {
		return _auteur;
	}

	public void set_auteur(Visiteur _auteur) {
		this._auteur = _auteur;
	}

	public Article get_article() {
		return _article;
	}

	public void set_article(Article _article) {
		this._article = _article;
	}
	
	
}
