package pojo;

import pojo_role.Role;

public class Team {
	private Role _role;
	private String _nom, _pseudo, _mail;

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
