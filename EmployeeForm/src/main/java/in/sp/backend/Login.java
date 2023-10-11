package in.sp.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginform")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String mail = request.getParameter("email");
		String pass = request.getParameter("pass1");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeForm","root","RAC#99#kitu");
			
		    	PreparedStatement ps = con.prepareStatement("select * from register where email=? and upass=?");
		    	ps.setString(1, mail);
		    	ps.setString(2, pass);
		    	
		    	ResultSet rs = ps.executeQuery();
		    	
		    	if (rs.next()) {
		    		HttpSession session = request.getSession();
		    		session.setAttribute("session_uname",rs.getString("uname"));
		    		
		    		RequestDispatcher rd = request.getRequestDispatcher("/Profile.jsp");
		    		rd.include(request, response);
				}
		    	else
		    	{
		    		response.setContentType("text/html");
		    		out.print("<h3 style='color:red'> Invalid Credential!</h3> ");
		    	    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp"); 	
		    	    rd.include(request, response);
		    	}
		    	
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
    		out.print("<h3 style='color:red'> Exception Occured!"+e.getMessage()+"</h3> ");
    	    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp"); 	
    	    rd.include(request, response);
		}
	}

}
