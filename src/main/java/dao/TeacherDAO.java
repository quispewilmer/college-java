package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import interfaces.TeacherInterface;
import model.Teacher;
import util.connections.MySQLConnection;

public class TeacherDAO implements TeacherInterface {

	@Override
	public int insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTeacher(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Teacher getTeacher(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Teacher> getTeachers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Teacher> teachers = null;

		try {
			connection = new MySQLConnection().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM tb_docente");
			resultSet = preparedStatement.executeQuery();

			System.out.println(resultSet);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}

		return teachers;
	}
}
