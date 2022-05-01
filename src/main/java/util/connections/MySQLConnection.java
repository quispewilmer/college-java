package util.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import io.github.cdimascio.dotenv.Dotenv;

public class MySQLConnection {
	Connection connection = null;
	Logger logger = Logger.getLogger(MySQLConnection.class.getName());
	Dotenv dotenv = null;

	public Connection getConnection() {
		try {
			dotenv = Dotenv.configure()
					.directory(System.getProperty("user.home"))
					.filename(".env")
					.load();
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = dotenv.get("MYSQL_DB_URL");
			String user = dotenv.get("MYSQL_DB_USER");
			String password = dotenv.get("MYSQL_DB_PASSWORD");
			connection = DriverManager.getConnection(url, user, password);
			logger.info("Successfully connected");
		} catch (SQLException e) {
			logger.info("There was an error with connection");
		} catch (ClassNotFoundException e) {
			logger.info("There was an error with connection");
		}
		
		return connection;
	}
}
