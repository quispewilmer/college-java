package factory;

import dao.MariaDBTeacherDAO;
import interfaces.TeacherInterface;

public class MariaDBDAOFactory extends DAOFactory {

	@Override
	public TeacherInterface getTeacherDAO() {
		// TODO Auto-generated method stub
		return new MariaDBTeacherDAO();
	}

}
