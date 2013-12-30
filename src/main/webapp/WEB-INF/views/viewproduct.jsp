<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thanks for adding the Product.</title>
</head>
<body>

<h2>Submitted Product Information</h2>
   <table>
    <tr>
        <td>Name</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>description</td>
        <td>${description}</td>
    </tr>
    <tr>
        <td>ID</td>
        <td>${id}</td>
    </tr>
</table>
<table>
<tr>
        <td>Name</td>
        <td>Description</td>
    </tr>
<c:forEach var="product" items="${productList}">
  <tr>
    <td>${product.name}</td>
    <td>${product.description}</td>
  </tr>
</c:forEach>
</table> 
</body>
</html>