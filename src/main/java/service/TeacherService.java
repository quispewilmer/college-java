package service;

import java.util.List;

import factory.DAOFactory;
import interfaces.TeacherInterface;
import model.Teacher;
import util.enums.DaoType;

public class TeacherService implements TeacherInterface{
	private DAOFactory daoFactory = DAOFactory.getDAOFactory(DaoType.MYSQL);
	private TeacherInterface teacherInterface = daoFactory.getTeacherDAO();
	
	@Override
	public int insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherInterface.insertTeacher(teacher);
	}
	@Override
	public int updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherInterface.updateTeacher(teacher);
	}
	@Override
	public int deleteTeacher(String id) {
		// TODO Auto-generated method stub
		return teacherInterface.deleteTeacher(id);
	}
	@Override
	public Teacher getTeacher(String id) {
		// TODO Auto-generated method stub
		return teacherInterface.getTeacher(id);
	}
	@Override
	public List<Teacher> getTeachers() {
		// TODO Auto-generated method stub
		return teacherInterface.getTeachers();
	}
	
	
}
