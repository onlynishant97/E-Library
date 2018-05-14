package Servlets;

import java.io.IOException;

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
 * Servlet implementation class AddLibrarian
 */
@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		//System.out.println(name+" "+email);
		Librarian lib=new Librarian(name, email, password, mobile);
		int add = AdminDao.addLibrarian(lib);
		if(add==1) {
			resp.sendRedirect("librariansaved.jsp");
		}
		else {
			resp.sendRedirect("adminloginform.jsp");
		}
	}
}
