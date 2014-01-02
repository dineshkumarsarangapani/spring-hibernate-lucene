<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.0.3.js"></script>
<script type="text/javascript" src="resources/js/services.js"></script>
<script type="text/javascript">

</script>
<link rel="stylesheet" type="text/css" href="resources/css/screen.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product Variants</title>
</head>
<body>
	<h2>Add Product Variant</h2>
	<form:form method="POST" action="/demo/product/productvariant">
		<table>
			<tr>
				<td><form:label path="type">Type of the Product Variant</form:label></td>
				<td><form:select path="type">
						<form:options />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="size">Size</form:label></td>
				<td><form:input path="size" /></td>
			</tr>
			<tr>
				<td><form:label path="color">Color</form:label></td>
				<td><form:input path="color" /></td>
			</tr>
			<tr>
				<td><form:hidden path="prodId" id="prod_id" /></td>
			</tr>
			<%--<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td><form:label path="uom">UOM</form:label></td>
				<td><form:input path="uom" /></td>
			</tr>
			<tr>
				<td><form:label path="currency">Currency</form:label></td>
				<td><form:input path="currency" /></td>
			</tr> --%>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>