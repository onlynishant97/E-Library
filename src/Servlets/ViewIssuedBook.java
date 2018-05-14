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

import Dao.BookDao;
import ModelClasses.Book;
import ModelClasses.IssueBook;

/**
 * Servlet implementation class ViewIssuedBook
 */
@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>View Issued Books</title>");
		out.println("<link rel='stylesheet' href='bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		req.getRequestDispatcher("librariannavbar.html").include(req, resp);
		out.println("<div class='container'>");
		List issuedbooks=BookDao.viewIssuedBook();
		
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>callNo</th><th>IssueDate</th><th>ReturnStatus</th><th>StudentId</th><th>StudentMobile</th><th>StudentName</th></tr>");
		for(Iterator itr=issuedbooks.iterator();itr.hasNext();) {
			IssueBook bean=(IssueBook) itr.next();
			out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getIssueddate()+"</td><td>"+bean.getReturnstatus()+"</td><td>"+bean.getStudentid()+"</td><td>"+bean.getStudentmobile()+"</td><td>"+bean.getStudentname()+"</td></tr>");
	}
		out.println("</table>");		
		out.println("</div>");
		out.close();
	}
}
