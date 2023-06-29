<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="org.springframework.web.client.RestTemplate"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   
    <title>Book List</title>
<%@include file="/WEB-INF/components/common_css_js_forall.jsp" %>
  </head>
  <body>

<%@include file="/WEB-INF/components/navbar.jsp" %>

<div class="container mt-5">


<div>
  

<div class="row justify-content-center">
    <div class="col">

        <h5 class="text-center">
       Book List...!
        </h5>
    </div>
    <div class="col ml-5 mb-3" align="right">
        <a href="addBook" class="btn btn-primary">Add Book</a>
    </div>
</div>
</div>


<table class="table text-center">
  <thead>
 
 
    <tr>
    
      <th>Book Code</th>
      <th>Book Name</th>
      <th>Author</th>
      <th>Date Added</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items = "${bookList}" var = "book">
    	<tr>
        <td>${book.bookCode}</td>
      	<td>${book.bookName}</td>
      	<td>${book.bookAuthor}</td>
      	<td>${book.dateTime}</td>

      	<td style="text-align: center;">

      	<c:url var="editBook" value="/editview" />
        <form action="${editBook}" method="post" style="display: inline">
          <input type="hidden" name="id" value="${book.bookCode}" />
        	  <button type="submit" class="btn btn-sm btn-primary">Edit</button>
        </form> &nbsp;&nbsp;

        <c:url var="delete" value="/delete" />
        <form action="${delete}" method="post" style="display: inline">
          <input type="hidden" name="id" value="${book.bookCode}" />
          	<button type="submit" class="btn btn-sm btn-danger">Delete</button>
        </form>

     
        </td>

    	</tr>
    </c:forEach>
  </tbody>
</table>


<br>
		<br>
		<c:if test="${Arrays.asList(bookList).size() == 0}">
			<header>
			<div>
				<table width = "100%">
					<tr>
						<td>
							<h2>
								Sorry! No matching Book found!
							</h2>
						</td>
						<td align = "right">
							<form action="/logout">
							<input type = "submit" value = "SignOut"/>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</header>
		</c:if> 
		<br>

</div>

  <!-- Footer -->
<%@include file="/WEB-INF/components/footer.jsp" %>


    
  </body>
</html>