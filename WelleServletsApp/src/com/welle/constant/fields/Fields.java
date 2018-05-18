package com.welle.constant.fields;

public class Fields {

	private static Fields fields = null;

	private Fields() {
	}

	public static Fields getFieldsInstance() {
		if (fields == null) {
			fields = new Fields();
		}
		return fields;
	}

	public String getUpDownFolder() {
		return UpDownFolder;
	}

	public String getDbName() {
		return DbName;
	}

	public String getDbUser() {
		return DbUser;
	}

	public String getDbPass() {
		return DbPass;
	}

	public String getJdbcToOracleDb() {
		return jdbcToOracleDb;
	}

	private String UpDownFolder = "C:\\Users\\velimir.avramovski\\Desktop\\test-uploads-download";

	private String DbName = "REGISTERUSER";
	private String DbUser = "WELLE";
	private String DbPass = "admin";
	private String jdbcToOracleDb = "jdbc:oracle:thin:@localhost:1521:xe";

}
