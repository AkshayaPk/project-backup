<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

  <!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>
<div  class="container">
<form action="/admin/addroute" method="post">
Enter Route Name:<input type="text" name="routename" required/><br>
Enter End Point :<input type="text" name="endpoint" required/><br>
Enter Route Bus No:<input type="number" name="busno" required/><br>
Enter Departure Date:<input type="date" name="depdate" required/><br>
Enter Departure Time:<input type="text" name="deptime" required/><br>
Enter Intermediary Point 1:<input type="text" name="ip1" required/><br>
Enter Intermediary Point 2:<input type="text" name="ip2" required/><br>
Enter Intermediary Point 3:<input type="text" name="ip3" required/><br>
Enter Intermediary Point 4:<input type="text" name="ip4" required/><br>
Enter Intermediary Point 5:<input type="text" name="ip5" required/><br>
Enter Intermediary Point 6:<input type="text" name="ip6" required/><br>
<input type="submit" value="ADD ROUTE" class="waves-effect waves-light btn"><br>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>