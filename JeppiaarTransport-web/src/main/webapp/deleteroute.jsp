<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Route</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class=container>
<form action="/admin/deleteroute" method="post">
Enter Bus Number :<input type="number" name="busno"/>
<input type="submit" value="DELETE ROUTE" class="waves-effect waves-light btn"/>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>