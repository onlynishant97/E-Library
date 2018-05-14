package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDao;

/**
 * Servlet implementation class IssueBook
 */
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String callno=request.getParameter("callno");
		String studentid=request.getParameter("studentid");
		String studentname=request.getParameter("studentname");
		String sstudentmobile=request.getParameter("studentmobile");
		long studentmobile=Long.parseLong(sstudentmobile);
		java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
		ModelClasses.IssueBook ib=new ModelClasses.IssueBook(callno, studentid, studentname, studentmobile, currentDate, "no");
		int i=BookDao.issueBook(ib);
		if(i>0) {
			response.sendRedirect("issuebooksuccessfully.jsp");
		}
		else {
			System.out.println("Book cant be issued due to shortage of books");
		}
	}
}
