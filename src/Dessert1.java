

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
 * Servlet implementation class Dessert1
 */
@WebServlet("/Dessert1")
public class Dessert1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter p=response.getWriter();
		String ch = request.getParameter("dessert");
		/*String q1 = request.getParameter("quantity1");
		Integer q11 = Integer.valueOf(q1);
		String q2 = request.getParameter("quantity2");
		Integer q22 = Integer.valueOf(q2);
		String q3 = request.getParameter("quantity3");
		Integer q33 = Integer.valueOf(q3);
		String q4 = request.getParameter("quantity4");
		Integer q44 = Integer.valueOf(q4);
		String q5 = request.getParameter("quantity5");
		Integer q55 = Integer.valueOf(q5);
		String q6 = request.getParameter("quantity6");
		Integer q66 = Integer.valueOf(q6);
		String q7 = request.getParameter("quantity7");
		Integer q77 = Integer.valueOf(q7);
		String q8 = request.getParameter("quantity8");
		Integer q88 = Integer.valueOf(q8);
		String q9 = request.getParameter("quantity9");
		Integer q99 = Integer.valueOf(q9);*/
		String query1 =("insert into cart(itemname,price) values('Gulab Jamun','50')");
		String query2 =("insert into cart(itemname,price) values('Rabri','120')");
		String query3 =("insert into cart(itemname,price) values('Gajar Halwa','150')");
		String query4 =("insert into cart(itemname,price) values('Kulfi','30')");
		String query5 =("insert into cart(itemname,price) values('Rabdi Faluda','150')");
		String query6 =("insert into cart(itemname,price) values('Rajbhog','40')");
		String query7 =("insert into cart(itemname,price) values('Rasmalai','60')");
		String query8 =("insert into cart(itemname,price) values('Moong Dal Halwa','140')");
		String query9 =("insert into cart(itemname,price) values('Suji Halwa','120')");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
			
			if(ch.equals("Add Item 1"))
			{			
				PreparedStatement ps= con.prepareStatement(query1);
				ps.executeUpdate();
				response.sendRedirect("dessert.html");
			}
			else if(ch.equals("Add Item 2"))
			{
				PreparedStatement ps= con.prepareStatement(query2);
				ps.executeUpdate();
				response.sendRedirect("dessert.html");
			}
			else if(ch.equals("Add Item 3"))
			{
				PreparedStatement ps= con.prepareStatement(query3);
				ps.executeUpdate();
				response.sendRedirect("dessert.html");
			}
			else if(ch.equals("Add Item 4"))
			{
				PreparedStatement ps= con.prepareStatement(query4);
				ps.executeUpdate();
				response.sendRedirect("dessert.html");
			}
			else if(ch.equals("Add Item 5"))
			{
				PreparedStatement ps= con.prepareStatement(query5);
				ps.executeUpdate();
				response.sendRedirect("dessert.html");
			}
			else if(ch.equals("Add Item 6"))
			{
				PreparedStatement ps= con.prepareStatement(query6);
				ps.executeUpdate();
				response.sendRedirect("dessert.html");
			}
			else if(ch.equals("Add Item 7"))
			{
				PreparedStatement ps= con.prepareStatement(query7);
				ps.executeUpdate();	
				response.sendRedirect("dessert.html");
			}
			else if(ch.equals("Add Item 8"))
			{
				PreparedStatement ps= con.prepareStatement(query8);
				ps.executeUpdate();
				response.sendRedirect("dessert.html");
			}
			else if(ch.equals("Add Item 9"))
			{
				PreparedStatement ps= con.prepareStatement(query9);
				ps.executeUpdate();
				response.sendRedirect("dessert.html");
			}

		}
			catch(Exception e)
			{
					p.println("Try Again");
			}
	}
	}
