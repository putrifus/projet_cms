package bdd;

import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class DAOmanager<T> {
	protected Connection connect = CoSQL.getInstance();
	protected Timestamp time = Timestamp.valueOf(LocalDateTime.now());
	
	public abstract StringBuffer find(StringBuffer strb);

	public abstract T create(T obj);

	public abstract T update(T obj);

	public abstract void delete(T obj);

	public abstract ArrayList<T> importation();
}
