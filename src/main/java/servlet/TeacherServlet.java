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
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import util.connections.MySQLConnection;
import util.enums.Gender;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet(name = "teacherServlet", description = "teacherServlet", urlPatterns = {
		"/teacherServlet" })
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
		System.out.println("Hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println();
		try {
			Teacher teacher = new Teacher(
					request.getParameter("firstName"),
					request.getParameter("lastName"),
					request.getParameter("email"),
					Integer.parseInt(request.getParameter("age")),
					Double.parseDouble(request.getParameter("money")),
					request.getParameter("phone"),
					Gender.valueOf(request.getParameter("gender")),
					new SimpleDateFormat("dd-MM-yyyy").parse(request.getParameter("birthday"))
					);
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = new MySQLConnection().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM tb_docente");
			resultSet = preparedStatement.executeQuery();
			
			System.out.println(resultSet);
		}catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
