package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Registerservlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String n=request.getParameter("name");
		String p=request.getParameter("password");
		String e=request.getParameter("email");
		String ad=request.getParameter("address");
		String co=request.getParameter("contact");
		
		Beanbook b1=new Beanbook();
		b1.setName(n);
		b1.setPassword(p);
		b1.setEmail(e);
		b1.setAddress(ad);
		b1.setContact(co);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itvedant","root","root");
		    PreparedStatement ps=con.prepareStatement("insert into custdetails values(?,?,?,?,?)");
		    ps.setString(1,n);
		    ps.setString(2,p);
		    ps.setString(3,e);
		    ps.setString(4,ad);
		    ps.setString(5,co);
		    int k=ps.executeUpdate();
		    if(k>0)
		    {
		    	pw.print("Register Sucessfully");
		    	
		    	response.sendRedirect("Login.html");
		    }
		    else
		    {
		    	pw.print("error...");
		    }
		}catch(Exception ex)
		{
			System.out.println(ex);
		}

		
		
	}

}
