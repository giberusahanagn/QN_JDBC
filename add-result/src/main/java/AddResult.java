
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt((req.getParameter("id")));
		String name = req.getParameter("name");
		int marks1 = Integer.parseInt(req.getParameter("marks1"));
		int marks2 = Integer.parseInt(req.getParameter("marks2"));
		int marks3 = Integer.parseInt(req.getParameter("marks3"));

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sahana", "root", "root");
			String s = "insert into students values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(s);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, marks1);
			preparedStatement.setInt(4, marks2);
			preparedStatement.setInt(5, marks3);

			int rows = preparedStatement.executeUpdate();

			PrintWriter printWriter = resp.getWriter();
			if(rows==0) {
				printWriter.println("data not added");
			}else {
				printWriter.println("data added successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
