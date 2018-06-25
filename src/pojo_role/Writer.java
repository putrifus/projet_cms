package pojo_role;

public class Writer extends Role{
	public Writer() {
		set_rolevalue(2);
		setModifTheme(false);
		setAddUser(false);
		
		setAddArticle(true);
		setCreateArticle(true);
		setEditArticle(true);
		
		setModo(true);
	}
}
