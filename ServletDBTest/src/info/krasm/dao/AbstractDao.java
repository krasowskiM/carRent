package info.krasm.dao;

import java.sql.*;
import java.util.*;

import info.krasm.query.TableRow;

public abstract class AbstractDao {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7111731?";

	// DB user credentials
	private static final String USER = "sql7111731";
	private static final String PASS = "833xLLj8CM";

	Connection conn = null;
	
	public int count(String sql, String columnName) throws SQLException, ClassNotFoundException{
		int countedRows = 0;
		try {
			Class.forName(JDBC_DRIVER).newInstance();

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute SQL query
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				countedRows = (int) Integer.parseInt(rs.getString(columnName));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
			catch (IllegalAccessException | InstantiationException e) {
				throw new ClassNotFoundException(e.getMessage());
				}
		return countedRows;
	}
	
	public String executeQueryOfOne(String query)throws SQLException, ClassNotFoundException{
		try {
			Class.forName(JDBC_DRIVER).newInstance();

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute SQL query
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String result="";
			
			while (rs.next()){
				result = rs.getString(0);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return result;
		}
			catch (IllegalAccessException | InstantiationException e) {
				throw new ClassNotFoundException(e.getMessage());
				}
	}
	
	public List<TableRow> executeQueryWithResults(String query)throws SQLException, ClassNotFoundException{
		try {
			Class.forName(JDBC_DRIVER).newInstance();

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute SQL query
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List<TableRow> results = new ArrayList<>();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			
			
			//dodawanie do listy? jak to dzialalo? :/
			while (rs.next()){
				TableRow tr = new TableRow();
				for (int i=1; i<=columnsNumber;i++){
					String value = rs.getString(i);
					String columnName = rsmd.getColumnName(i);
					tr.addValue(columnName, value);
				}
				results.add(tr);
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return results;
		}
			catch (IllegalAccessException | InstantiationException e) {
				throw new ClassNotFoundException(e.getMessage());
				}
	}
	
	public void executeDefaultQuery(String query)throws SQLException,ClassNotFoundException{
		try {
			Class.forName(JDBC_DRIVER).newInstance();

			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Execute SQL query
			Statement stmt = conn.createStatement();
			stmt.executeQuery(query);
			
			stmt.close();
			conn.close();
		}
			catch (IllegalAccessException | InstantiationException e) {
				throw new ClassNotFoundException(e.getMessage());
				}
	}
}
