package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Dao.AdminDao;
import HibernateUtil.HibernateUtil;
import ModelClasses.Librarian;

/**
 * Servlet implementation class ViewLibrarian
 */
@WebServlet("/ViewLibrarian")
public class ViewLibrarian extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Librarian</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("adminnavbar.html").include(req, resp);
		out.println("<div class='container'>");
		List lib=AdminDao.viewLibrarian();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Mobile</th></tr>");
		for(Iterator itr=lib.iterator();itr.hasNext();) {
				Librarian bean=(Librarian) itr.next();
				out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td></tr>");
		}
		out.println("</table>");		
		out.println("</div>");
		out.close();
	}
}
