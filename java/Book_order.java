package com.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Book_order")
public class Book_order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Book_order() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("name");
		String ad=request.getParameter("address");
		String co= request.getParameter("contact");
		String itnm=request.getParameter("itemname");
		int quant=Integer.parseInt(request.getParameter("quantity"));
		
		Bean b1=new Bean();
		b1.setName(n);
		b1.setAddress(ad);
		b1.setContact(co);
		b1.setItemname(itnm);
		b1.setQuantity(quant);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itvedant","root","root");
		    PreparedStatement ps=con.prepareStatement("insert into orderbook(name,address,contact,Itemname,quantity) values(?,?,?,?,?)");
		    ps.setString(1,n);
		    ps.setString(2,ad);
		    ps.setString(3,co);
		    ps.setString(4,itnm);
		    ps.setInt(5,quant);
		    int k=ps.executeUpdate();
		    if(k>0)
		    {
		    	out.print("Order booked successfully");
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('order booked sucessfully');");
		    	
		    	out.println("</script>");
		    	
		    	response.sendRedirect("order_choice.html");
		    }
		    else
		    {
		    	out.print("error...");
		    }
		}catch(Exception ex)
		{
			System.out.println(ex);
		}

		
		
	}

	}


