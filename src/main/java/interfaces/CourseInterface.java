package interfaces;

import java.util.List;

import model.Course;

public interface CourseInterface {
	public int insertCourse();
	public int updateCourse();
	public int deleteCourse();
	public Course getCourse();
	public List<Course> getCourses();
}
