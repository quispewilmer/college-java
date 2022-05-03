package factory;

import dao.MySQLCourseDAO;
import dao.MySQLTeacherDAO;
import interfaces.CourseInterface;
import interfaces.TeacherInterface;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public TeacherInterface getTeacherDAO() {
		// TODO Auto-generated method stub
		return new MySQLTeacherDAO();
	}

	@Override
	public CourseInterface getCourseDAO() {
		// TODO Auto-generated method stub
		return new MySQLCourseDAO();
	}
}
