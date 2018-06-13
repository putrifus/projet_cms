package pojo_role;

public class Writer extends Role{
	public Writer() {
		setModifTheme(false);
		setAddUser(false);
		
		setAddArticle(true);
		setCreateArticle(true);
		setEditArticle(true);
		
		setModo(true);
	}
}
