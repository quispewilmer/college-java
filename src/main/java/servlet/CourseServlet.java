package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Course;
import service.CourseService;

@WebServlet(name = "course", description = "course", urlPatterns = { "/course", "/course/*" })
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson gson = new Gson();
	private CourseService courseService = null;

	public CourseServlet() {

	}

	public void init(ServletConfig config) throws ServletException {
		this.courseService = new CourseService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Course> coursesList = courseService.getCourses();
		String coursesJson = gson.toJson(coursesList);

		response.setStatus(200);
		response.setHeader("Content-Type", "application/json");
		response.getOutputStream().println(coursesJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
