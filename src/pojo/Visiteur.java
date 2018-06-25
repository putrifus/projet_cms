package pojo;

public class Visiteur {
	private String _nom, _mail;

	public Visiteur(String string) {
		this._nom = string;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public String get_mail() {
		return _mail;
	}

	public void set_mail(String _mail) {
		this._mail = _mail;
	}
}
