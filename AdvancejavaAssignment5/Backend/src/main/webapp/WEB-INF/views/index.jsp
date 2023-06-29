<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="ISO-8859-1">
<%@include file="/WEB-INF/components/common_css_js_forall.jsp" %>

<script type="text/javascript">
	$enable - shadows
</script>
<title>login page</title>
</head>
<style>  
body {  
  background: Pink !important;  
  font-family: 'Muli', sans-serif;  
}  
h1 {  
  color: black;  
  padding-bottom: 2rem;  
  font-weight: bold;  
}  
a {  
  color: #333;  
}  
a:hover {  
  color: #E8D426;  
  text-decoration: none;  
}  
.form-control:focus {  
    color: #000;  
    background-color: #fff;  
    border: 2px solid #E8D426;  
    outline: 0;  
    box-shadow: none;  
}  
.btn {  
  background: pink;  
  border: #E8D426;  
}  
.btn:hover {  
  background: Black;  
  border: #E8D426;  
}  
</style>  
<body>

	<div class="pt-5">  
    <h1 class="text-center">  Login Form  </h1> 
<div class="container">  
                <div class="row">  
                    <div class="col-md-5 mx-auto">  
                        <div class="card card-body">
                        <%@include file="/WEB-INF/components/message.jsp" %>  
                      <form  action="checkuser" method="post" >   
                   <div class="form-group required">  
               <label for="exampleInputEmail1" class="form-label">User Name</label>
				    <input name="name" type="text" class="form-control"  minlength="5" maxlength="50" required>
               </div>                      
       <div class="form-group required"> 
<div class="mb-3">
				    <label for="exampleInputPassword1" class="form-label">Password</label>
				    <input name="password" type="password" class="form-control"  minlength="5" maxlength="50" required>
				  </div>  
       </div>  
      <a href="${pageContext.request.contextPath }/register">Create New Account</a>
				  <div class="container text-center">
				  <button type="submit" class="btn btn-primary border-0">Submit</button>
				  <button type="reset" class="btn btn-primary border-0">Reset</button>
				  </div>
        
               </form>  
              
                        </div>  
                    </div>  
                </div>  
            </div>  
</div>  
</body>
</html>


