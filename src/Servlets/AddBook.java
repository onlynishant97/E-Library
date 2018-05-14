package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;
import ModelClasses.Book;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callno=request.getParameter("callno");
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String squantity=request.getParameter("quantity");
		int quantity=Integer.parseInt(squantity);
		Book bean=new Book(callno,name,author,publisher,quantity);
		int i=BookDao.addBook(bean);
		if(i>0) {
			response.sendRedirect("bookaddedsuccessfully.jsp");
		}
		else response.sendRedirect("addbookform.jsp");
	}
}
