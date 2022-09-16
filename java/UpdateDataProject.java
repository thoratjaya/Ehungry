
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

@WebServlet("/UpdateDataProject")

public class UpdateDataProject extends HttpServlet 
{
    
	private static final long serialVersionUID = 1L;
public UpdateDataProject() {
        
    }


	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
    {
         response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String u =request.getParameter("name");
        int i=Integer.parseInt(request.getParameter("id"));
        String itnm=request.getParameter("itemname");
		int quant=Integer.parseInt(request.getParameter("quantity"));
        
        Bean pb =new Bean();
         pb.setName(u);
         pb.setId(i);
         pb.setItemname(itnm);
 		pb.setQuantity(quant);
 		
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
           out.print("1");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itvedant","root","root");
           PreparedStatement ps=con.prepareStatement("update orderbook set name=?,Itemname=?,quantity=? where orderid=?");
           
           ps.setString(1,u);
          
           ps.setString(2,itnm);
           ps.setInt(3,quant);
           ps.setInt(4,i);
           
           
           int status=ps.executeUpdate();
           if(status>0)
           {
               out.println("order is updated successfully");
              response.sendRedirect("order_choice.html");
           }
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
}  
}
