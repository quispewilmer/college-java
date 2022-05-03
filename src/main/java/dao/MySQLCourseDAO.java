package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.CourseInterface;
import model.Course;
import util.connections.MySQLConnection;

public class MySQLCourseDAO implements CourseInterface {

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
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Course course = null;
		List<Course> courseList = null;

		try {
			connection = new MySQLConnection().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM course");
			courseList = new ArrayList<Course>();
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				course = new Course(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
				courseList.add(course);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return courseList;
	}

}
