

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signin
 */
@WebServlet("/signin")
public class signin extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter p= response.getWriter();
		String username= request.getParameter("username");
		String password= request.getParameter("psw");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
			 String query="Select username,psw from admin where username=? and psw=?";
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, username);
			 ps.setString(2, password);
			 ResultSet rs=ps.executeQuery();
			 while(rs.next())
			 {
				p.println("login succesfully");
				//response.sendRedirect("menu.html");
				
			 }
		}
		catch(Exception e)
		{			
			System.out.println("try again");				 
		}		
		
	}
	}


