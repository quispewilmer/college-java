package factory;

import dao.SQLServerTeacherDAO;
import interfaces.TeacherInterface;

public class SQLServerDAOFactory extends DAOFactory {

	@Override
	public TeacherInterface getTeacherDAO() {
		// TODO Auto-generated method stub
		return new SQLServerTeacherDAO();
	}

}
