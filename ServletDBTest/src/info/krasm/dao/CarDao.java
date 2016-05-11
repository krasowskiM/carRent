package info.krasm.dao;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

import info.krasm.query.QueryBuilder;
import info.krasm.query.TableRow;

public class CarDao extends AbstractDao {
	private static final String TABLE_NAME = "Samochody";
	private String[] columnNames = { "idSamochody", "Marka", "Model", "nrRej", "kilometry" };
	private String select = "select * from `Samochody`";
	private String insert = "insert into `Samochody` values";
	private String count = "select count(`" + columnNames[0] + "`) from `Samochody`";
	// private ArrayList<String> dbResults;
	// private String type;
	// private String model;
	// private String regNumber;
	// private String gasType;
	// private String description;
	// private String kms;

	public CarDao() {

	}

	// przeprowadz zapytanie do bazy dotyczace wszystkich samochodow
	public List<TableRow> selectAllCars() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String query = qb.selectAll().from(TABLE_NAME).toString();
		//String query = qb.select("idSamochody").from(TABLE_NAME).toString();
		List<TableRow> results = executeQueryWithResults(query);
		return results;
	}

	// zapytania o szczegolowe dane, prawdopodobnie TODO zapytania z konkretnym
	// id samochodu
	public String getCarsType() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[0]).from(TABLE_NAME).toString();
		String type = executeQueryOfOne(query);
		return type;
	}

	public String getCarsModel() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[1]).from(TABLE_NAME).toString();
		String model = executeQueryOfOne(query);
		return model;
	}

	public String getCarsRegNumber() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[2]).from(TABLE_NAME).toString();
		String regNumber = executeQueryOfOne(query);
		return regNumber;
	}

	public String getCarsKms() throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String query = qb.select(columnNames[3]).from(TABLE_NAME).toString();
		String kms = executeQueryOfOne(query);
		return kms;
	}

	// tworzenie auta w bazie
	public void createCar(String type, String model, String regNumber, String kms)
			throws ClassNotFoundException, SQLException {
		QueryBuilder qb = new QueryBuilder();
		String[] values = { type, model, regNumber, kms };
		String query = qb.insert().into(TABLE_NAME).values(values).toString();
		executeDefaultQuery(query);
	}

	public int countCars() throws ClassNotFoundException, SQLException {

		int countedCars;
		countedCars = count(count, "count(`idSamochody`)");

		return countedCars;
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getInsert() {
		return insert;
	}

	public void setInsert(String insert) {
		this.insert = insert;
	}

}
