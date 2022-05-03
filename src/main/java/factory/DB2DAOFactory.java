package factory;

import dao.DB2TeacherDAO;
import interfaces.CourseInterface;
import interfaces.TeacherInterface;

public class DB2DAOFactory extends DAOFactory {

	@Override
	public TeacherInterface getTeacherDAO() {
		// TODO Auto-generated method stub
		return new DB2TeacherDAO();
	}

	@Override
	public CourseInterface getCourseDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
