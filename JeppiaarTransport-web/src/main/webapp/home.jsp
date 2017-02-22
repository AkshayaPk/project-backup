<html>
<head>
<!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
          
</head>
<body>
 <jsp:include page="header.jsp"></jsp:include>
 <div class="row center card-panel purple lighten-4">
<div class="col s6 md6 offset-s3">
 <div class="container">
 <form action="/admin/login" method="post">
 <div class="input-field col s12">
          Enter Username :<input placeholder="Username" id="first_name" name="username" type="text" class="validate" required>
</div>
<div class="input-field col s12">
          Enter Password :<input placeholder="Password" id="first_name" type="password" name="password" class="validate" required>
</div>
<div>
<input type=submit value="LOGIN" class="waves-effect waves-light btn"/>
</div>
 </form>
 </div>
 </div>
 </div>
 <jsp:include page="footer.jsp"></jsp:include>
  
 </body>

 </html>