<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@include file="components/common_css_js_forall.jsp"%>
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
                      <form  action="LoginServlet" method="post" >  
<input type="hidden" name="_csrf" value="7635eb83-1f95-4b32-8788-abec2724a9a4">  
                   <div class="form-group required">  
              <lSabel for="username"> Enter your Username </lSabel>  
             <input type="text" class="form-control text-lowercase" id="username" required="" name="email" value="">  
               </div>                      
       <div class="form-group required">  
    <label class="d-flex flex-row align-items-center" for="password"> Enter your Password   
     <a class="ml-auto border-link small-xl" href="#"> Forget Password? </a> </label>  
<input type="password" class="form-control" required="" id="password" name="password" value="">  
       </div>  
     
         <div class="form-group pt-1">  
      <button class="btn btn-primary btn-block" type="submit" name="logIn"> Log In </button>  
                  </div>  
               </form>  
              
                        </div>  
                    </div>  
                </div>  
            </div>  
</div>  
</body>
</html>