package interfaces;

import java.util.List;

import model.Teacher;

public interface TeacherInterface {
	public int insertTeacher(Teacher teacher);
	public int updateTeacher(Teacher teacher);
	public int deleteTeacher(String id);
	public Teacher getTeacher(String id);
	public List<Teacher> getTeachers();
}
