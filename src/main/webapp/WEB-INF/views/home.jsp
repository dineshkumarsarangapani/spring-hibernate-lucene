<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="resources/js/services.js"></script>
</head>
<body>
<h1> 
	Welcome to Lister Products !!!
</h1>
You can <a href="addProduct">create a product </a> and Search a product.
<br />
<h3>Here are the list of products fetched from services</h3>
<br />
<img style="display:none;" id="loading-image" alt="Fetching Products" src="resources/images/loading.gif" />
</body>
</html>
