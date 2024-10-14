
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
	try {
		int id=	Integer.parseInt(req.getParameter("id"));

		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sahana","root","root");
		String query="select * from students where id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
	
		preparedStatement.setInt(1, id);
		ResultSet resultSet=preparedStatement.executeQuery();
		PrintWriter printWriter=resp.getWriter();
	
		if(resultSet.next()) {
		id=	resultSet.getInt(1);
		String name=	resultSet.getString(2);
		int marks1=	resultSet.getInt(3);
		int marks2=	resultSet.getInt(4);
		int marks3=	resultSet.getInt(5);
	//	printWriter.println(resultSet);
		printWriter.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
