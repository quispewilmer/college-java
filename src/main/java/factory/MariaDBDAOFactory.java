package factory;

import dao.MariaDBTeacherDAO;
import interfaces.CourseInterface;
import interfaces.TeacherInterface;

public class MariaDBDAOFactory extends DAOFactory {

	@Override
	public TeacherInterface getTeacherDAO() {
		// TODO Auto-generated method stub
		return new MariaDBTeacherDAO();
	}

	@Override
	public CourseInterface getCourseDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
