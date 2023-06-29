<%@page import="com.nagarro.entities.ProductDetails"%>
<%@page import="com.nagarro.helper.Factoryprovider"%>
<%@page import="org.hibernate.Session"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="components/common_css_js_forall.jsp" %>
</head>
<body>
<h5 class="text-center bg-primary p-2">Edit your product</h5>
<%

int productID=Integer.parseInt(request.getParameter("product_id").trim());
Session s=Factoryprovider.getFactory().openSession();
ProductDetails p=(ProductDetails)s.get(ProductDetails.class,productID);


%>
<form action="UpdateServlet" method="post" enctype="multipart/form-data" class="m-5">
            <input value ="<%= p.getProductId() %>"  name="pid" type="hidden"/>
			<div> 

				<span>Title</span> <input class=" ml-5" type="text" name="Title" value="<%=p.getItemTitle() %>">

			</div>
			<div class="mt-2">

				<span>Quantity</span> <input class="ml-3" type="number" name="Quantity" value="<%=p.getItemQuantity() %>">

			</div>
			<div class="mt-2">

				<span>Size</span> <input class=" ml-5" type="text" name="Size" value="<%=p.getSize() %>">

			</div>
			<div class="mt-2">

				<span>Image</span> <input class=" ml-5" type="file" name="Image" value="img/product/<%=p.getImage()%>">
					
			<div class="mt-2">

				<button class="btn btn-outline-success">Edit Product</button>

			</div>
			
		
		</form>	




</body>
</html>