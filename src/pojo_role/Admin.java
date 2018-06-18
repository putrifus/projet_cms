package pojo_role;

public class Admin extends Role {
	public Admin() {
		setModifTheme(true);
		setAddUser(true);

		setAddArticle(true);
		setCreateArticle(true);
		setEditArticle(true);

		setModo(true);

	}
}
