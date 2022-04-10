package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TeacherDAO;
import model.Teacher;
import util.connections.MySQLConnection;
import util.enums.Gender;
import util.enums.RequestType;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet(name = "teachers", description = "teachers", urlPatterns = { "/teachers" })
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		selectTeacher(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			RequestType requestType = RequestType.valueOf(request.getParameter("action"));

			switch (requestType) {
			case INSERT: {
				insertTeacher(request, response);
				break;
			}
			case UPDATE: {
				updateTeacher(request, response);
				break;
			}
			case DELETE: {
				deleteTeacher(request, response);
				break;
			}
			case SELECT: {
				selectTeacher(request, response);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + requestType);
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void selectTeacher(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		TeacherDAO teacherDAO = new TeacherDAO();
		List<Teacher> listTeachers = teacherDAO.getTeachers();
		try {
			request.setAttribute("teachersList", listTeachers);
			request.getRequestDispatcher("listTeachers.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

	private void deleteTeacher(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void updateTeacher(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void insertTeacher(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			Teacher teacher = new Teacher(request.getParameter("id"), request.getParameter("firstName"), request.getParameter("lastName"),
					request.getParameter("email"), Integer.parseInt(request.getParameter("age")),
					Double.parseDouble(request.getParameter("money")), request.getParameter("phone"),
					Gender.valueOf(request.getParameter("gender")),
					new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("birthday")));
			TeacherDAO teacherDAO = new TeacherDAO();
			teacherDAO.insertTeacher(teacher);
			doGet(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
