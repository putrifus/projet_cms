package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bdd.DAOmanager;
import pojo.Team;
import pojo_role.Admin;
import pojo_role.Modo;
import pojo_role.Role;
import pojo_role.Writer;

public class TeamDAO extends DAOmanager<Team> {
	private TeamDAO team = new TeamDAO();
	private ArrayList<Team> list = new ArrayList<Team>();

	private TeamDAO() {
	}

	public TeamDAO singleton() {
		return team;
	}

	@Override
	public StringBuffer find(StringBuffer strb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Team create(Team obj) {
		// setup un membre de la team
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT pseudo FROM cms.team were pseudo = '" + obj.get_pseudo() + "'");
			if (result.next()) {
				System.out.println("deja un memebre avec ce pseudo");
				return null;
			} else {
				PreparedStatement prepare = this.connect.prepareStatement("INSERT INTO cms.team VALUES (?, ?, ?, ?)");
				prepare.setString(1, obj.get_nom());
				prepare.setString(2, obj.get_pseudo());
				prepare.setString(3, obj.get_mail());
				prepare.setInt(4, obj.get_role().get_rolevalue());
				prepare.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public Team update(Team obj) {
		// change le role d'un memebre de la team
		return null;
	}

	@Override
	public void delete(Team obj) {
		// supprime un team mate inférieur

	}

	@Override
	public ArrayList<Team> importation() {
		// TODO Auto-generated method stub
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)
					.executeQuery("SELECT * FROM cms.team ORDER BY role ASC");
			String str;
			Role r;
			
			while (result.next()) {
				if (result.getInt(4) == 1)
					r = new Admin();
				else if (result.getInt(4) == 2)
					r = new Writer();
				else if (result.getInt(4) == 3)
					r = new Modo();
				else
					r = null;
				
				Team t = new Team(r, result.getString(1), result.getString(2), result.getString(3));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
