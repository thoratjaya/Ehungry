<%@ page import="java.io.*,java.util.*,java.sql.*" %>
    <%@ page import="javax.servlet.http.*,javax.servlet.*" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
		<meta name="viewport" content="width=device-width">
		<title>KFC</title>
		<link rel="stylesheet" href="style.css">
		<!-- Favicons -->
		<link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png">
		
		<!-- Font Awesome -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
		
</head>
<body>
<nav class="navbar navbar-expand-lg sticky-top navbar-dark bg-dark">
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		  </button>

		  <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
		 
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			<li class="nav-item">
				<a class="nav-link" href="index.html" style="color: #ffffff;"><img src="images//home.png" height="40px" class="d-inline-block align-text-center">Home</a>
			  </li>
			
			 <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="kfc.html" role="button" data-bs-toggle="dropdown" aria-expanded="false" style="color: #ffffff;"><img src="images//menu.png" height="40px" class="d-inline-block align-text-center">
            Menu
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="book_order.html" style="background-color:aqua;">Burger</a></li>
			<li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="book_order.html" style="background-color:aqua;">Pizza</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="book_order.html" style="background-color:aqua;">Sandwitch</a></li>
          </ul>
        </li>
		 	 	 
			 
			  <li class="nav-item">
				<a class="nav-link" href="order_choice.html" style="color: #ffffff;"><img src="images//foodorder.jpg" height="40px" class="d-inline-block align-text-center">Order</a>
			  </li>
			 
			 
			  <li class="nav-item">
				<a class="nav-link" href="#" style="color: #ffffff;"><img src="images//deals.png" height="40px" class="d-inline-block align-text-center" >Deals</a>
			  </li>
			  
			</ul>
			<button type="button" class="btn btn-dark border border-white rounded px-5" style="font-size: 18px;" data-toggle="modal" data-target="#map">Our Location</button>
			<i class="fa fa-search" style="font-size:40px; padding-left: 50px; color: #999999;"></i>
			<i class="fa fa-shopping-cart" style="font-size:40px; padding-left: 30px; padding-right: 100px; color: #999999;"></i>
				 
		 </div>
		</nav>


<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost/itvedant"  user="root" password="root"/>


<sql:query dataSource="${db}"   var="rs">
select * from orderbook;
</sql:query>


 <table class="table table-striped w-auto" >
<tr>
<th>Order id</th>
<th>Name</th>
<th>address</th>
<th>contact</th>
<th>Itemname</th>
<th>Quantity</th>
<tr>

<c:forEach var="table" items="${rs.rows}">
<tr>	
<td><c:out value="${table.orderid}"/></td>
<td><c:out value="${table.name}"/></td>
<td><c:out value="${table.address}"/></td>
<td><c:out value="${table.contact}"/></td>
<td><c:out value="${table.Itemname}"/></td>
<td><c:out value="${table.quantity}"/></td>
</tr>
</c:forEach>
</table>
<br>
<center>
    <button type="submit" class="btn btn-primary" formaction="index.html" >Back to Home</button>
    </center>
</body>
</html>
