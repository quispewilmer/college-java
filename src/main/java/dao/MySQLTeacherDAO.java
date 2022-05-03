package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.TeacherInterface;
import model.Teacher;
import util.connections.MySQLConnection;
import util.enums.Gender;

public class MySQLTeacherDAO implements TeacherInterface {

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
			preparedStatement.setInt(8, teacher.getGender().name().equals("MALE") ? 1 : 0);
			preparedStatement.setDate(9, new java.sql.Date(teacher.getBirthday().getTime()));

			result = preparedStatement.executeUpdate();
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
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = new MySQLConnection().getConnection();
			preparedStatement = connection.prepareStatement(
					"UPDATE teacher SET firstName = ?, lastName = ?, email = ?, age = ?, money = ?, phone = ?, gender = ?, birthday = ? WHERE id = ?");
			preparedStatement.setString(1, teacher.getFirstName());
			preparedStatement.setString(2, teacher.getLastName());
			preparedStatement.setString(3, teacher.getEmail());
			preparedStatement.setInt(4, teacher.getAge());
			preparedStatement.setDouble(5, teacher.getMoney());
			preparedStatement.setString(6, teacher.getPhone());
			preparedStatement.setInt(7, teacher.getGender().name().equals("MALE") ? 1 : 0);
			preparedStatement.setDate(8, new java.sql.Date(teacher.getBirthday().getTime()));
			preparedStatement.setString(9, teacher.getId());

			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public int deleteTeacher(String id) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = new MySQLConnection().getConnection();
			preparedStatement = connection.prepareStatement("DELETE FROM teacher WHERE id = ?");
			preparedStatement.setString(1, id);

			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		return result;
	}

	@Override
	public Teacher getTeacher(String id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Teacher teacher = null;

		try {
			connection = new MySQLConnection().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE id = ?");
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();
			teacher = new Teacher();

			while (resultSet.next()) {
				teacher = new Teacher(resultSet.getString(1), resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getInt(6), resultSet.getDouble(7), resultSet.getString(8),
						Gender.valueOf(resultSet.getInt(9) == 1 ? "MALE" : "FEMALE"), resultSet.getDate(10));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teacher;
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
				teacher = new Teacher(resultSet.getString(1), resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getInt(6), resultSet.getDouble(7), resultSet.getString(8),
						Gender.valueOf(resultSet.getInt(9) == 1 ? "MALE" : "FEMALE"), resultSet.getDate(10));
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
