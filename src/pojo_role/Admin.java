package pojo_role;

public class Admin extends Role {
	public Admin() {
		set_rolevalue(1);
		setModifTheme(true);
		setAddUser(true);
		//
		setAddArticle(true);
		setCreateArticle(true);
		setEditArticle(true);
		//
		setModo(true);
	}
}
