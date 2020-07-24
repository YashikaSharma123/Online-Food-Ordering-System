

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
 * Servlet implementation class Starters
 */
@WebServlet("/Starters")
public class Starters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p =  response.getWriter();	
		String starter = request.getParameter("starter");
		String q = request.getParameter("quantity");
		int quantity = Integer.parseInt(q);
		String query =("Select * from menu where itemname = '"+starter+"'" );
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
			PreparedStatement ps= con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String itemno = rs.getString(1);
				String itemname = rs.getString(2);
				int stock = rs.getInt(3);
				int price = rs.getInt(4);
				p.println("Itemno = "+itemno+"\t\tItemname = "+itemname+"\t\tStock = "+stock+"\t\tPrice"+price);    
				if(quantity>stock)
				{
					p.println("Item Out Of Stock");
				}
				else
				{
					p.println(price*quantity);
				}
			}
		}
				catch(Exception e)
				{
					p.println("Exception occur");
				}
	}
}