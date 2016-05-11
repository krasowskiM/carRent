package info.krasm.dao;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import info.krasm.query.QueryBuilder;
import info.krasm.query.TableRow;

public class UserDao extends AbstractDao {
	private String[] columnNames = { "username", "password", "email" };
	private static final String TABLE_NAME = "User";
	// private static final String SELECT= "select * from `User`";
	// private static final String INSERT = "insert into `User`(username,
	// password, email) values(";
	// private ArrayList<String> dbResults;
	// private String username;
	// private String password;
	// private String email;

	public UserDao() {

	}

	// przeprowadz zapytanie do bazy dotyczace wszystkich userkow
	public List<TableRow> selectAllClients() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		// String query = qb.selectAll().from(TABLE_NAME).toString();
		String query = qb.select("idUser").from(TABLE_NAME).toString();
		List<TableRow> results = executeQueryWithResults(query);
		return results;
	}

	// zapytania o szczegolowe dane, prawdopodobnie TODO zapytania z konkretnym
	// id userka
	public String getUsername() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[0]).from(TABLE_NAME).toString();
		String username = executeQueryOfOne(query);
		return username;
	}

	public String getUsersPassword() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[1]).from(TABLE_NAME).toString();
		String password = executeQueryOfOne(query);
		return password;
	}

	public String getUsersEmail() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[2]).from(TABLE_NAME).toString();
		String email = executeQueryOfOne(query);
		return email;
	}

	// tworzenie usera w bazie
	public void createUser(String username, String password, String email)
			throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String[] values = { username, password, email };
		String query = qb.insert().into(TABLE_NAME).values(values).toString();
		executeDefaultQuery(query);
	}
	
	public boolean isLoggedIn(){
		boolean loginStat=false;
		//sprawdzamy czy uzytkownik jest zalogowany
		return loginStat;
	}
	
	public boolean isWorker(){
		boolean workerStat=false;
		//sprawdzamy czy w bazie danych posiada w polu Is_Worker wartosc true
		return workerStat;
	}
	
	public boolean isAdmin(){
		boolean adminStat=false;
		//sprawdzamy czy w bazie danych posiada w polu Is_Admin wartosc true
		return adminStat;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

}
