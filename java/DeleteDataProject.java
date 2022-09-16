
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

@WebServlet("/DeleteDataProject")

public class DeleteDataProject extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public DeleteDataProject() {
		
	}
	
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
       
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        int id =Integer.parseInt(request.getParameter("id"));
        Bean pb =new Bean();
        pb.setId(id);
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itvedant","root","root");
           PreparedStatement ps=con.prepareStatement("delete from orderbook where orderid=?");
           
           ps.setInt(1,id);
           int status=ps.executeUpdate();
           if(status>0)
           {
               out.println("Order cancelled successfully");
              response.sendRedirect("order_choice.html");
           }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
    }
}
