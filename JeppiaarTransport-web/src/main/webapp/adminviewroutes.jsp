<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>View Routes</title>
<script
  src="https://code.jquery.com/jquery-3.1.1.min.js"
  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
  crossorigin="anonymous"></script>
  <script>
  $(document).ready(function(){
	    $('.tooltipped').tooltip({delay: 50});
	  });
	    
  </script>
</head>
<body>

		<jsp:include page="header.jsp"></jsp:include>
<div>
<ul id="dropdown1" class="dropdown-content">
  <li><a href="addroute.jsp">ADD A ROUTE</a></li>
  <li><a href="updateroute.jsp">UPDATE A ROUTE</a></li>
  <li class="divider"></li>
  <li><a href="deleteroute.jsp">DELETE A ROUTE</a></li>
</ul>
<nav>
  <div class="nav-wrapper">
    <a>SERVICES PROVIDED</a>
    <ul class="right hide-on-med-and-down">
      <!-- Dropdown Trigger -->
      <li><a class="dropdown-button" href="#!" data-activates="dropdown1">Services<i class="material-icons right">arrow_drop_down</i></a></li>
    </ul>
  </div>
</nav>
</div>		
		<div class="card-panel purple lighten-4">
		<table class="highlight bordered">
<thead>
<th>ROUTE</th>
<th>BUS NO</th>
<th>DEP DATE</th>
<th>DEP TIME</th>
</thead>
<c:forEach var="c" items="${ROUTE_LIST}" varStatus="i">
						<tr >
							<td>${c.routeId.routeId.routeName}</td>
							<td> <a class="tooltipped" data-position="bottom" data-delay="50" data-tooltip="${c.ip1}<br>${c.ip2}<br>${c.ip3}<br>${c.ip4}<br>${c.ip5}<br>${c.ip6}<br>" data-html="true">${c.routeId.busNo}</a>
							</td>
							
							<td>${c.routeId.departureDate}</td>
							<td>${c.routeId.departureTime}</td>
							
							
						</tr>
					</c:forEach>
</table>	
		</div>
		<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>