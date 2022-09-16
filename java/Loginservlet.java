package com.java;

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


@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Loginservlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String n=request.getParameter("name");
		String p=request.getParameter("password");
		//String e=request.getParameter("email");
		//String ad=request.getParameter("address");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itvedant","root","root");
			PreparedStatement ps=con.prepareStatement("select name,password from custdetails where name=? and password=? ");
		    ps.setString(1,n);
		    ps.setString(2,p);
		    ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	if(n.equals(rs.getString(1))&& p.equals(rs.getString(2)))
		    	{
		    		pw.println ("<html><body><h1>Login sucessful</h1></body></html>");
		    		response.sendRedirect("index.html");
		    	}
		    }
		    else
		    {
		    	pw.print("invalid user...");
		    }
		}   catch(Exception ex)
		    {System.out.println(ex); }
	}

}
