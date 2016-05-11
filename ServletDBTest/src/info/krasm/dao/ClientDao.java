package info.krasm.dao;

import java.sql.*;
//import java.util.ArrayList;
import java.util.List;

import info.krasm.query.QueryBuilder;
import info.krasm.query.TableRow;

public class ClientDao extends AbstractDao{
	private static final String TABLE_NAME = "Klienci";
	private String[] columnNames={"Imie", "Nazwisko", "Phone", "Email"};
	//private String select= "select * from `Klienci`";
	//private String insert = "insert into `Klienci` values";
	//private ArrayList<String> dbResults;
	//private String name;
	//private String surname;
	//private String address;
	//private String city;
	
	public ClientDao(){
		
	}
	
	//przeprowadz zapytanie do bazy dotyczace wszystkich klientow
	public List<TableRow> selectAllClients() throws ClassNotFoundException, SQLException{
		QueryBuilder qb = new QueryBuilder();
		String query = qb.selectAll().from(TABLE_NAME).toString();
		//String query = qb.select("idKlient").from(TABLE_NAME).toString();
		List<TableRow> results = executeQueryWithResults(query);
		return results;
	}
	
	//zapisywanie wartosci do kolejnych kolumn? zeby nie trzeba bylo tworzyc "na twardo" logiki w serwlecie
	
	//zapytania o szczegolowe dane, prawdopodobnie TODO zapytania z konkretnym id klienta
	public String getClientsName() throws ClassNotFoundException, SQLException{
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[0]).from(TABLE_NAME).toString();
		String name = executeQueryOfOne(query);
		return name;
	}
	
	public String getClientsSurname() throws ClassNotFoundException, SQLException{
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[1]).from(TABLE_NAME).toString();
		String surname = executeQueryOfOne(query);
		return surname;
	}
	
	public String getClientsPhone() throws ClassNotFoundException, SQLException{
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[2]).from(TABLE_NAME).toString();
		String phone = executeQueryOfOne(query);
		return phone;
	}
	
	public String getClientsEmail() throws ClassNotFoundException, SQLException{
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[3]).from(TABLE_NAME).toString();
		String email = executeQueryOfOne(query);
		return email;
	}
	
	//tworzenie klienta w bazie
	public void createClient(String name, String surname, String phone, String email) throws ClassNotFoundException, SQLException{	
		QueryBuilder qb = new QueryBuilder();
		String[] values = {name, surname, phone, email};
		String query = qb.insert().into(TABLE_NAME).values(values).toString();
		executeDefaultQuery(query);
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}
}
