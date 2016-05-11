package info.krasm.query;

public class QueryBuilder {
	private StringBuilder sb;

	public QueryBuilder() {
		sb = new StringBuilder();
	}

	public QueryBuilder append(String value) {
		sb.append(value);
		sb.append(SQLConst.SPACE);

		return this;
	}

	public QueryBuilder select() {
		append(SQLConst.SELECT);

		return this;
	}

	public QueryBuilder selectAll() {
		select();
		append(SQLConst.ASTERISK);

		return this;
	}
	
	public QueryBuilder select(String... columns) {
		select();

		for (int i = 0; i < columns.length; i++) {
			append(columns[i]);

			if (i < columns.length - 1) {
				append(SQLConst.COMA);
			}
		}
		return this;
	}

	public String toString() {
		return sb.toString();
	}

	public QueryBuilder from(String tableName) {
		append(SQLConst.FROM);
		sb.append(SQLConst.GRAVIS);
		sb.append(tableName);
		append(SQLConst.GRAVIS);

		return this;
	}

	public QueryBuilder insert() {
		append(SQLConst.INSERT);

		return this;
	}

	public QueryBuilder into(String tableName) {
		append(SQLConst.INTO);
		sb.append(SQLConst.GRAVIS);
		sb.append(tableName);
		append(SQLConst.GRAVIS);

		return this;
	}

	public QueryBuilder into(String tableName, String... columns) {
		append(SQLConst.INTO);
		sb.append(SQLConst.GRAVIS);
		sb.append(tableName);
		append(SQLConst.GRAVIS);
		sb.append(SQLConst.L_BRACKET);
		for (int i = 0; i<columns.length;i++){
			append(columns[i]);
			if (i < columns.length - 1){
				append(SQLConst.COMA);
			}
		}
		sb.append(SQLConst.R_BRACKET);
		return this;
	}

	public QueryBuilder values(String... values) {
		append(SQLConst.VALUES);
		sb.append(SQLConst.L_BRACKET);
		for (int i = 0; i < values.length; i++) {
			sb.append(SQLConst.APOSTROPHE);
			append(values[i]);
			sb.append(SQLConst.APOSTROPHE);
			if (i < values.length - 1) {
				append(SQLConst.COMA);
			}
		}
		sb.append(SQLConst.R_BRACKET);
		sb.append(SQLConst.SEMICOLON);

		return this;
	}
}
