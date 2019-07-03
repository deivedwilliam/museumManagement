package dados.MdD;

import java.sql.SQLException;

public interface IMapeadordeDados<T> {
	public void set(T obj) throws SQLException;
	public void insert() throws SQLException;
	public void delete() throws SQLException;
	public void update() throws SQLException;
}
