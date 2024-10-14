
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstNumber = req.getParameter("firstNumber");
		String secondNumber = req.getParameter("secondNumber");

		int number1 = Integer.parseInt(firstNumber);
		int number2 = Integer.parseInt(secondNumber);
		int result = number1 + number2;
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("Result: " + result);
	}

}
