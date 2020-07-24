

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
 * Servlet implementation class admin1
 */
@WebServlet("/admin1")
public class admin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter p=response.getWriter();
    	PrintWriter out = response.getWriter();
    	out.print("<table border= '5' cellspacing = '3' cellpadding = '3' width = '600'><tr><th>Itemname</th><th>Price</th></tr>");
    		String query =("select * from cart");
    		String query1 = ("select SUM(price) from cart");
    		response.setContentType("text/html");
    			
    		try
    		{
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
    			PreparedStatement ps= con.prepareStatement(query);
    			ResultSet rs = ps.executeQuery(query);
    			while(rs.next())
    			{
    				out.print("<tr><td>");
    				out.println(rs.getString(1));
    				out.print("</td>");
    				out.print("<td>");
    				out.println(rs.getString(2));
    				out.print("</td>");
    				out.print("</tr>");
    			}
    						
    	}	catch(Exception e)
    		{
    		out.println("An error occured :(");
    		}
    out.println("</table>");
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
    	PreparedStatement ps= con.prepareStatement(query1);
    	ResultSet rs = ps.executeQuery(query1);
    	String Total = "";
    	while(rs.next())
    	{
    		Total = rs.getString(1);
    		out.println("<table border= '5' cellspacing = '3' cellpadding = '3' width = '600'><tr><th>Total Amount </th></tr>");
    		out.print("<tr><td>");
    		out.println(rs.getString(1));
    		out.print("</td>");
    		out.print("</tr>");
    		Thread.sleep(100);
    	}
    	//out.println("<input type = 'submit' class = 'createbtn1' value = 'Continue'>");
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
    out.println("</table>");
    }



	}


