package pojo;

import pojo_role.Role;

public class Team {
	private Role _role;
	private String _nom, _pseudo, _mail;

	public Role get_role() {
		return _role;
	}

	public void set_role(Role _role) {
		this._role = _role;
	}

	public String get_nom() {
		return _nom;
	}

	public void set_nom(String _nom) {
		this._nom = _nom;
	}

	public String get_pseudo() {
		return _pseudo;
	}

	public void set_pseudo(String _pseudo) {
		this._pseudo = _pseudo;
	}

	public String get_mail() {
		return _mail;
	}

	public void set_mail(String _mail) {
		this._mail = _mail;
	}

	//pour affichage du pseudo
	public String toString() {
		return _pseudo;
	}

	//constructeur complet
	public Team(Role r, String n, String p, String m) {
		this._role = r;
		this._nom = n;
		this._pseudo = p;
		this._mail = m;
	}
	
	//constructeur pour une simple recherche/affichage
	public Team(String p) {
		this._pseudo = p;
	}
}
