package factory;

import dao.TeacherDAO;
import util.enums.DaoType;

public abstract class DAOFactory {
	public abstract TeacherDAO getTeacherDAO();
	
	public static DAOFactory getDaoFactory(DaoType daoType) {
		switch (daoType) {
		case MYSQL:
			return new MySQLDAOFactory();
		case SQLSERVER:
			return new SQLServerDAOFactory();
		case MARIADB:
			return new MariaDBDAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		case DB2:
			return new DB2DAOFactory();
			default:
				return null;
		}
	}
}
