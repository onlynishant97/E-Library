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

/**
 * Servlet implementation class ViewBook
 */
@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
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
		
		req.getRequestDispatcher("librariannavbar.html").include(req, resp);
		out.println("<div class='container'>");
		List books=BookDao.viewBooks();
		out.println("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>callNo</th><th>Name</th><th>Author</th><th>Publisher</th><th>Quantity</th><th>Issued</th></tr>");
		for(Iterator itr=books.iterator();itr.hasNext();) {
			Book bean=(Book) itr.next();
			out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublisher()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td></tr>");
	}
		out.println("</table>");		
		out.println("</div>");
		out.close();
	}
}
