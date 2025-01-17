package com.quntnex.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.quntnex.model.Student;

public class GetResult extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Student student = new Student();
		student.setId(id);

		student.getResult();

		id = student.getId();
		String name = student.getName();
		int marks1 = student.getMarks1();
		int marks2 = student.getMarks2();
		int marks3 = student.getMarks3();

		HttpSession session = request.getSession(true);
		session.setAttribute("sid", id); // sid=id;
		session.setAttribute("sname", name);
		session.setAttribute("smarks1", marks1);
		session.setAttribute("smarks2", marks2);
		session.setAttribute("smarks3", marks3);
		
		response.sendRedirect("/get-result-mvc/getResultSuccess.jsp");
	

	}

}
