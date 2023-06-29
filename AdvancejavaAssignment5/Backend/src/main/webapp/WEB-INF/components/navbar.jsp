<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- Container wrapper -->
 <div class="container">

<a class="navbar-brand mb-0 h2" href="">Book Management</a>
    <!-- Toggle button -->


   
      <!-- Left links -->

      <div class="d-flex align-items-center">

        <p class="ml-5 mb-0 h5">Welcome User</p>
         <a class="btn btn-outline-danger ml-5  navbar-right" href="${pageContext.request.contextPath }/logout">logout</a>
        

      </div>
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->