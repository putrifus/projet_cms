package pojo;

import java.time.LocalDateTime;

public class Article {
	private String _titre, _resume, _contenu;
	private Team _writer;
	private Categorie _cat;
	private boolean _visible, _comm;
	private LocalDateTime _date;

	// constructeur pour la création d'un nouvel article
	public Article(String str, Team t, Categorie c) {
		this._titre = str;
		this._visible = false;
		this._comm = false;
		this._writer = t;
		this._cat = c;
	}
	
	//simplifié pour traitement bdd
	public Article(String str) {
		this._titre = str;
	}

	// constructeur de recherche et l'import
	public Article(String str, String resum, String contenu, Team t, Categorie c, boolean b, boolean bb,
			LocalDateTime date) {
		this._titre = str;
		this._resume = resum;
		this._contenu = contenu;
		this._visible = b;
		this._comm = bb;
		this._writer = t;
		this._cat = c;
		this._date = date;
	}

	public String get_titre() {
		return _titre;
	}

	public void set_titre(String _titre) {
		this._titre = _titre;
	}

	public String get_resume() {
		return _resume;
	}

	public void set_resume(String _resume) {
		this._resume = _resume;
	}

	public String get_contenu() {
		return _contenu;
	}

	public void set_contenu(String _contenu) {
		this._contenu = _contenu;
	}

	public Team get_writer() {
		return _writer;
	}

	public void set_writer(Team _writer) {
		this._writer = _writer;
	}

	public Categorie get_cat() {
		return _cat;
	}

	public void set_cat(Categorie _cat) {
		this._cat = _cat;
	}

	public boolean is_visible() {
		return _visible;
	}

	public void set_visible(boolean _visible) {
		this._visible = _visible;
	}

	public boolean is_comm() {
		return _comm;
	}

	public void set_comm(boolean _comm) {
		this._comm = _comm;
	}

	public LocalDateTime get_date() {
		return _date;
	}

	public void set_date(LocalDateTime _date) {
		this._date = _date;
	}

	@Override
	public String toString() {
		return "Article [_titre=" + _titre + ", _resume=" + _resume + ", _contenu=" + _contenu + ", _writer=" + _writer
				+ ", _cat=" + _cat + ", _date=" + _date + "]";
	}

}
