<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.mysql.cj.jdbc.Blob"%>
<%@page import="java.util.List"%>
<%@page import="com.nagarro.entities.*"%>
<%@page import="com.nagarro.entities.ProductDetails"%>
<%@page import="com.nagarro.Dao.ProductDao"%>
<%@page import="com.nagarro.helper.Factoryprovider"%>
<%@page import="org.hibernate.SessionFactory"%>


<%
	Admin user=(Admin)session.getAttribute("currentAdmin");
if(user==null){
	session.setAttribute("message","Login first");
	response.sendRedirect("index.jsp");
	return;
}


else{
%>
<!DOCTYPE html>
<html>
<head>
<%@include file="components/common_css_js_forall.jsp"%>
<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>
<jsp:include page="navbar.jsp" />

<jsp:include page="message.jsp" />

	<div class="mt-2 ml-3">
		<h6>Please enter product details to add to stock</h6>
	</div>


	<div class="ml-5 mt-5">
		<form action="ProductServlet" method="post"
			enctype="multipart/form-data">
			<div>

				<span>Title</span> <input class=" ml-5" type="text" name="Title">

			</div>
			<div class="mt-2">

				<span>Quantity</span> <input class="ml-3" type="number"
					name="Quantity">

			</div>
			<div class="mt-2">

				<span>Size</span> <input class=" ml-5" type="text" name="Size">

			</div>
			<div class="mt-2">

				<span>Image</span> <input class=" ml-5" type="file" name="Image"
					id="filess" onchange="Filevalidation()">
			</div>
			<div>
				<small id="valid-image-message" class="text-danger">product
					image size should be 64 kb or small</small>
			</div>
			<div class="mt-2">

				<button class="btn btn-outline-primary" id="addproduct">Add
					Product</button>

			</div>


		</form>

		<section class="container mt-4">
			<div>
				<table class="table table-bordered ">
					<thead>
						<tr class="table-primary">
							<th scope="col">S.No.</th>
							<th scope="col">Title</th>
							<th scope="col">Quantity</th>
							<th scope="col">Size</th>
							<th scope="col">Image</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody id="tBody">
					<jsp:include page="upload.jsp" />
						
					</tbody>
				</table>
			</div>
		</section>
		<script type="text/javascript">
	$(document).ready(loadProductData);
	
	function loadProductData() {
		 $("#valid-image-message").hide();
       
	}
	</script>
		<script>
	 Filevalidation =()=> {
	        let fi = document.getElementById('filess');
	        // Check if any file is selected.
	        if (fi.files.length > 0) {
	        	
	        	 var filename = $('#filess').val().split('\\').pop();
		        	
		        	$('#file-label').html(filename);
	        	
	            for (let i = 0; i <= fi.files.length - 1; i++) {
	  
	                const fsize = fi.files.item(i).size;
	                const file = Math.round((fsize / 1024));
	                // The size of the file.
	                if (file >= 64) {
	                   $("#addproduct").hide();
	                   $("#valid-image-message").show();
	                } else {
	                	$("#valid-image-message").hide();
	                	$("#addproduct").show();
	                }
	            }
	        }
	    }
	</script>
</body>
</html>
<%} %>
