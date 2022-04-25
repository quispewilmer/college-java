package util.enums;

public enum DaoType {
	MYSQL(1), SQLSERVER(2), MARIADB(3), ORACLE(4), DB2(5);
	
	private int DaoName;

	private DaoType(int daoName) {
		DaoName = daoName;
	}

	public int getDaoName() {
		return DaoName;
	}

	public void setDaoName(int daoName) {
		DaoName = daoName;
	}
}
