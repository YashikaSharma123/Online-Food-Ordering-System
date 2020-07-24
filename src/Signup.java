

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
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p= response.getWriter();
		String username= request.getParameter("username");
		String email= request.getParameter("email");
		String mobile= request.getParameter("mobile");
		String password= request.getParameter("psw");
		String address= request.getParameter("address");
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
			 String query=("insert into register(username,email,mobile,psw,address) values(?,?,?,?,?)");
			 PreparedStatement ps=con.prepareStatement(query);
			 ps.setString(1, username);
			 ps.setString(2, email);
			 ps.setString(3, mobile);
			 ps.setString(4, password);
			 ps.setString(5, address);
			 ps.executeUpdate();
			 p.println("Register Successfull");
			}
		
		catch(Exception e)
			{			
				p.println("Registration Failed");				 
			}		

		}

	}
