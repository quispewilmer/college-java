package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import interfaces.TeacherInterface;
import model.Teacher;
import util.connections.MySQLConnection;
import util.enums.Gender;

public class TeacherDAO implements TeacherInterface {

	@Override
	public int insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = new MySQLConnection().getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO teacher VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			preparedStatement.setString(1, teacher.getId());
			preparedStatement.setString(2, teacher.getFirstName());
			preparedStatement.setString(3, teacher.getLastName());
			preparedStatement.setString(4, teacher.getEmail());
			preparedStatement.setInt(5, teacher.getAge());
			preparedStatement.setDouble(6, teacher.getMoney());
			preparedStatement.setString(7, teacher.getPhone());
			preparedStatement.setObject(8, teacher.getGender());
			preparedStatement.setDate(9, new java.sql.Date(teacher.getBirthday().getTime()));
			
			result = 1;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		return result;
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
		Teacher teacher = null;

		try {
			connection = new MySQLConnection().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM teacher");
			resultSet = preparedStatement.executeQuery();
			teachers = new ArrayList<Teacher>();

			while (resultSet.next()) {
				teacher = new Teacher(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getInt(5), resultSet.getDouble(6), resultSet.getString(7),
						Gender.valueOf(resultSet.getInt(8) == 1 ? "MALE" : "FEMALE"), resultSet.getDate(9));
				teachers.add(teacher);
			}
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
