package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;


/**
 * Servlet implementation class ReturnBook
 */
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callno=request.getParameter("callno");
		String sstudentid=request.getParameter("studentid");
		int studentid=Integer.parseInt(sstudentid);
		int i=BookDao.returnBook(callno, sstudentid);
		if(i==0) {
			response.sendRedirect("returnbooksuccessfully.jsp");;
		}
		
	}
}
