package edu.pfe.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/FirstServlet.html")
public class FirstServlet extends HttpServlet{

	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String user=req.getParameter("user");
	// TODO Auto-generated method stub
	resp.getWriter().write("<HTML> <BODY><H1> Hello from "+user+" servlet!! </H1></BODY></html>");
	resp.flushBuffer();
}
}