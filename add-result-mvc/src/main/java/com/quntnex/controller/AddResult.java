package com.quntnex.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quntnex.model.Student;

public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt((req.getParameter("id")));
		String name = req.getParameter("name");
		int marks1 = Integer.parseInt(req.getParameter("marks1"));
		int marks2 = Integer.parseInt(req.getParameter("marks2"));
		int marks3 = Integer.parseInt(req.getParameter("marks3"));

		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setMarks1(marks1);
		student.setMarks2(marks2);
		student.setMarks3(marks3);
		int rowsAffected = student.addResult();
		if (rowsAffected == 1) {
			resp.sendRedirect("/add-result-mvc/AddResultSuccess.html");
		} else {
			resp.sendRedirect("/add-result-mvc/AddResultFailure.html");
		}
	}

}
