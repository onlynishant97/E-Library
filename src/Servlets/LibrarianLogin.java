package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.LibrarianDao;

/**
 * Servlet implementation class LibrarianLogin
 */
@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int validate=LibrarianDao.checkUser(req.getParameter("email"),req.getParameter("password"));
		if(validate==1)resp.sendRedirect("librarianhome.jsp");
		else resp.sendRedirect("homepage.jsp");
	}
}
