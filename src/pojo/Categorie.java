package pojo;

public class Categorie {
	private String _titre;
	private int _ordre;

	public Categorie(int i, String string) {
		this._ordre = i;
		this._titre = string;
	}

	public Categorie(String string) {
		this._titre = string;
	}

	public String get_titre() {
		return _titre;
	}

	public void set_titre(String _titre) {
		this._titre = _titre;
	}

	public int get_ordre() {
		return _ordre;
	}

	public void set_ordre(int _ordre) {
		this._ordre = _ordre;
	}

	public String toString() {
		return _titre;
	}
}
