package info.krasm.query;

import java.util.HashMap;
import java.util.Map;

public class TableRow {
	//map -> <columnName, valueOfColumn>
	//2nd map? -> <columnIndex, valueOfColumn>
	//dodac zwracanie wartosci bez wstawiania kolumny albo po indeksie
	private Map<String, String> dbResults;
	
	public TableRow() {
		dbResults = new HashMap<>();
	}
	
	public void addValue(String columnName, String valueOfColumn){
		dbResults.put(columnName, valueOfColumn);
	}
	
	public void getValue(String columnName){
		dbResults.get(columnName);
	}
	
	public String getValueString(String columnName){
		String result = dbResults.get(columnName);
		
		return result;
	}
}
