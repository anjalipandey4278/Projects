
<%@page import="com.nagarro.entities.Admin"%>
<% Admin loggeduser=(Admin)session.getAttribute("currentAdmin"); %>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- Container wrapper -->
  <div class="container">
 
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarButtonsExample"
      aria-controls="navbarButtonsExample"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarButtonsExample">
      <!-- Left links -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <div  class="text-right">
          
          <h5>Welcome 
           <%=loggeduser.getEmail().split("@")[0]%></h5>
           </div>
        </li>
      </ul>
      <!-- Left links -->

      <div class="d-flex align-items-center">
      
          <a href="Logoutservlet" class="btn btn-primary me-3 ml-5">Logout</a>
       

      </div>
    </div>
    <!-- Collapsible wrapper -->
  </div>
  <!-- Container wrapper -->
</nav>