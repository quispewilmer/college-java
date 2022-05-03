package factory;

import interfaces.CourseInterface;
import interfaces.TeacherInterface;
import util.enums.DaoType;

public abstract class DAOFactory {
	public abstract TeacherInterface getTeacherDAO();
	public abstract CourseInterface getCourseDAO();
	
	public static DAOFactory getDAOFactory(DaoType daoType) {
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
