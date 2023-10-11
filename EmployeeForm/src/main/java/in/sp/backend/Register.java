package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		String id = req.getParameter("id");
		String name = req.getParameter("name1");
		String mail = req.getParameter("email");
		String password = req.getParameter("pass");
		String mobile = req.getParameter("mobile");
		String gen = req.getParameter("gender1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeForm","root","RAC#99#kitu");
			
			PreparedStatement ps = con.prepareStatement("insert into register values(?,?,?,?,?,?)");//? placeholder, positional parameter
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, password);
			ps.setString(4, mail);
			ps.setString(5, mobile);
			ps.setString(6, gen);
			
			int count = ps.executeUpdate();
			if (count>0) {
				
				resp.setContentType("text/html");
				  out.print("<h3 style='color=green'> user Register Successfully </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			else
			{
				resp.setContentType("text/html");
				  out.print("<h3 style ='color=red'> User not registeres due to invalid credential!  </h3>");
				RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
				rd.include(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			  out.print("<h3 style ='color=red'> Exception Occured ! "+e.getMessage()+"  </h3>");
			RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
			rd.include(req, resp);
		}
	}

}
