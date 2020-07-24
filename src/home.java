

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String query2 = ("delete from cart");
  		try
  		{
  			Class.forName("com.mysql.jdbc.Driver");
  			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
  			Statement stmt = con.createStatement();
			int executeUpdate = stmt.executeUpdate(query2);	
  		}
  		catch(Exception e)
  		{
  			e.printStackTrace();
  		}
  		response.sendRedirect("homepage.html");
	}

}
