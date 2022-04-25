package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import service.TeacherService;
import util.enums.Gender;

@WebServlet(name = "teachers", description = "teachers", urlPatterns = { "/teachers", "/teachers/*" })
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TeacherService teacherService;

	public void init() {
		teacherService = new TeacherService();
	}

	public TeacherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();

		try {
			switch (pathInfo) {
			case "/insert":
				insertTeacher(request, response);
				break;
			case "/update":
				updateTeacher(request, response);
				break;
			case "/delete":
				deleteTeacher(request, response);
				break;
			case "/list":
				listTeachers(request, response);
				break;
			case "/new":
				showRegisterForm(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			default:
				listTeachers(request, response);
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Teacher teacher = teacherService.getTeacher(id);

		request.setAttribute("teacher", teacher);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/editTeacher.jsp");
		requestDispatcher.forward(request, response);
	}

	private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registerTeacher.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listTeachers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Teacher> listTeachers = teacherService.getTeachers();

		request.setAttribute("teachersList", listTeachers);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listTeachers.jsp");
		requestDispatcher.forward(request, response);
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");

		teacherService.deleteTeacher(id);
		response.sendRedirect("/teachers/");
	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, ParseException, IOException {
		Teacher teacher = new Teacher(request.getParameter("id"), request.getParameter("firstName"),
				request.getParameter("lastName"), request.getParameter("email"),
				Integer.parseInt(request.getParameter("age")), Double.parseDouble(request.getParameter("money")),
				request.getParameter("phone"), Gender.valueOf(request.getParameter("gender")),
				new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("birthday")));

		teacherService.updateTeacher(teacher);
		response.sendRedirect("/teachers/");
	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response)
			throws NumberFormatException, ParseException, IOException {
		Teacher teacher = new Teacher(request.getParameter("id"), request.getParameter("firstName"),
				request.getParameter("lastName"), request.getParameter("email"),
				Integer.parseInt(request.getParameter("age")), Double.parseDouble(request.getParameter("money")),
				request.getParameter("phone"), Gender.valueOf(request.getParameter("gender")),
				new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("birthday")));

		teacherService.insertTeacher(teacher);
		response.sendRedirect("/teachers/");
	}
}
