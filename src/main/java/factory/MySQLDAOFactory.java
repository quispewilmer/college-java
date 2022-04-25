package factory;

import dao.TeacherDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public TeacherDAO getTeacherDAO() {
		// TODO Auto-generated method stub
		return new TeacherDAO();
	}

}
