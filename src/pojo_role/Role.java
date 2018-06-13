package pojo_role;

public abstract class Role {
	private boolean addUser, addArticle, modifTheme, createArticle, editArticle, modo;

	public boolean isAddUser() {
		return addUser;
	}

	public boolean isAddArticle() {
		return addArticle;
	}

	public boolean isModifTheme() {
		return modifTheme;
	}

	public boolean isCreateArticle() {
		return createArticle;
	}

	public boolean isEditArticle() {
		return editArticle;
	}

	public boolean isModo() {
		return modo;
	}

	protected final void setAddUser(boolean addUser) {
		this.addUser = addUser;
	}

	protected final void setAddArticle(boolean addArticle) {
		this.addArticle = addArticle;
	}

	protected final void setModifTheme(boolean modifTheme) {
		this.modifTheme = modifTheme;
	}

	protected final void setCreateArticle(boolean createArticle) {
		this.createArticle = createArticle;
	}

	protected final void setEditArticle(boolean editArticle) {
		this.editArticle = editArticle;
	}

	protected final void setModo(boolean modo) {
		this.modo = modo;
	}
	
	
}
