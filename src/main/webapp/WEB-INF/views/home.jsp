<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="resources/js/services.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/screen.css">
</head>
<body>
<h1> 
	Welcome to Lister Products !!!
</h1>
You can <a href="addProduct">create a product </a> and Search a product.
<input type="text" id="search-box" placeholder="Search..." />
<button id="search-button"> Search Product</button>
<img style="display:none;" id="loading-image" alt="Fetching Products" src="resources/images/loading.gif" />	
<span class="search-error" id="search-error"></span>
<br />
<a href="JavaScript:void(0);" id="re-index">Re-Index Data</a>
<h3>Here are the list of products fetched from services and search result</h3>
<div id="search-result">
<table id="hor-minimalist-b">
 <thead>
  <tr>
        <td>Name</td>
        <td>Description</td>
        <td>Category</td>
        <td>Price</td>
        <td>Unit of Measure</td>
        <td>Currency</td>
         <td>Operations</td>
  </tr>
  </thead>
  <tbody id="tbody-data">
  
  </tbody>
</table> 

</div>
</body>
</html>
