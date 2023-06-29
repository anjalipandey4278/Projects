<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   <%@include file="/WEB-INF/components/common_css_js_forall.jsp" %>  
    <title>Book List</title>

  </head>
  <body>

<%@include file="/WEB-INF/components/navbar.jsp" %>

<div class="container">


<div class="row">
<h6 class="text-center">Edit Book Details</h6>
</div>
<div class="row py-1">
          <!-- First Column -->
          <div class="col-md-8 offset-md-2">
            <!-- Form -->
            <fieldset class="form-group border p-3">
              <legend  class="w-auto px-2">Edit Book</legend><hr>
              <form action="update" method="post" id="enrollment-form" >
                <div class="row mb-3">
                  <div class="col-3 col-md-4 text-start">
                    <label for="" class="form-label">Book Code</label>
                  </div>
                  <div class="col-9 col-md-8 text-center">
                    <input type="number" readonly class="form-input m-0 w-100 rounded border-1" value="${bookList.getbookCode()}" name="bookCode" required/>
                  </div>
                </div>
                <div class="row mb-3">
                  <div class="col-3 col-md-4 text-start">
                    <label for="" class="form-label">Book Name</label>
                  </div>
                  <div class="col-9 col-md-8 text-center">
                    <input type="text" class="form-input m-0 w-100 rounded border-1" value="${bookList.getbookName()}" name="bookName" required/>
                  </div>
                </div>
  
                <div class="row mb-3">
                  <div class="col-3 col-md-4 text-start">
                    <label for="" class="form-label">Author</label>
                   
                  </div>
                  <div class="col-9 col-md-8 text-center">
                   <select class="form-select m-0 w-100 rounded border-1" name="bookAuthor" id="author" aria-label="Default select example">
                  <option value=" ${booList.getbookAuthor()}">${bookList.getbookAuthor()}</option>
                    
             <c:forEach items = "${authorList}" var = "author">
                    <option value=" ${author.authName}">${author.authName}</option>
                    </c:forEach>
                     
                   </select>
                  </div>
                </div>
  
                <div class="row mb-3">
                  <div class="col-3 col-md-4 text-start">
                      <label for="" class="form-label">Added On</label>
                  </div>
                  <div class="col-9 col-md-8 text-center">
                      <input type="date" class="form-input m-0 w-100 rounded border-1" value="${bookList.getdateTime()}" name="dateTime" required/>
                  </div>
                </div>
  
                <div class="row mb-3 mt-2">
                  <div class="col">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button class="btn btn-danger" type="reset" onclick="">Clear</button>
                  </div>
                </div>
              </form>
              </fieldset>
          </div>
          </div>

</div>






<%@include file="/WEB-INF/components/footer.jsp" %>


</html>