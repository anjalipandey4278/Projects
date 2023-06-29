
<%@page import="java.util.Iterator"%>
<%@page import="com.nagarro.entities.ProductDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.nagarro.helper.Factoryprovider"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.nagarro.entities.Admin"%>
<%
	Admin loggedINAdmin = (Admin) session.getAttribute("currentAdmin");
%>

<%
	
	try {

		Session s=Factoryprovider.getFactory().openSession();
		

		
		
		System.out.println(s);

		int i = 0;

		s.beginTransaction();

		Admin admin = (Admin) s.get(Admin.class,loggedINAdmin.getEmail());

		List<ProductDetails> list = admin.getProducts();

		Iterator<ProductDetails> iterator = list.iterator();

		while (iterator.hasNext()) {

			i++;

			ProductDetails tempProduct = (ProductDetails) iterator.next();

		
%>
<tr>

	<th scope="row"><%=i%></th>
	<td id="title<%=tempProduct.getProductId()%>"><%=tempProduct.getItemTitle()%></td>
	<td id="quantity<%=tempProduct.getProductId()%>"><%=tempProduct.getItemQuantity()%></td>
	<td id="itemSize<%=tempProduct.getProductId()%>"><%=tempProduct.getSize()%></td>
	<td id="image<%=tempProduct.getProductId()%>"><img height="100"
		width="100" alt="not found"
		src="img/Products/<%=tempProduct.getImage()%>"></td>
	<td id="action<%=tempProduct.getProductId()%>">
		
			<a href="edit.jsp?product_id=<%=tempProduct.getProductId()%>" class="btn btn-success">Edit</a>
	
		
			<a href="DeleteServlet?product_id=<%=tempProduct.getProductId() %>"class="btn btn-danger">Delete</a>
		
	</td>
</tr>

<%
	}

		s.close();

	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>

