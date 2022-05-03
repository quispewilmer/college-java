package service;

import java.util.List;

import factory.DAOFactory;
import interfaces.CourseInterface;
import model.Course;
import util.enums.DaoType;

public class CourseService implements CourseInterface {
	private DAOFactory daoFactory = DAOFactory.getDAOFactory(DaoType.MYSQL);
	private CourseInterface courseInterface = daoFactory.getCourseDAO();

	@Override
	public int insertCourse() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCourse() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCourse() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Course getCourse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseInterface.getCourses();
	}

}
