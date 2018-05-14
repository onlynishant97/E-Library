package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname=req.getParameter("email");
		String pass=req.getParameter("password");
		System.out.println(uname+" "+pass);
		if(uname.equals("admin@admin.com") && pass.equals("admin")) {
			req.getRequestDispatcher("adminhome.jsp").include(req, resp);
		}
		else {
			req.getRequestDispatcher("adminlogin.jsp").include(req, resp);
		}
	}
}
