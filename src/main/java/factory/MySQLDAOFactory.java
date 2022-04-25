package factory;

import dao.MySQLTeacherDAO;
import interfaces.TeacherInterface;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public TeacherInterface getTeacherDAO() {
		// TODO Auto-generated method stub
		return new MySQLTeacherDAO();
	}

}
