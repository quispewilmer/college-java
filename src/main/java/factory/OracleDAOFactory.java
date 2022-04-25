package factory;

import dao.OracleTeacherDAO;
import interfaces.TeacherInterface;

public class OracleDAOFactory extends DAOFactory {

	@Override
	public TeacherInterface getTeacherDAO() {
		// TODO Auto-generated method stub
		return new OracleTeacherDAO();
	}

}
