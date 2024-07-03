<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.TblProductocl3" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Cliente</title>
</head>
<body bgcolor="#c5dec9">
	<h1 align="center">Actualizar Producto</h1>
	
	<form method="post" action="ControladorProducto">
		<%
			String cod = request.getAttribute("codigo").toString(); 
			String nom = (request.getAttribute("nombre") != null)?request.getAttribute("nombre").toString():"";
			String pre = (request.getAttribute("precio") != null)?request.getAttribute("precio").toString():"";
			String preVen = (request.getAttribute("precioVenta") != null)?request.getAttribute("precioVenta").toString():"";
			String est = (request.getAttribute("estado") != null)?request.getAttribute("estado").toString():"";
			String des =(request.getAttribute("descrip") != null)?request.getAttribute("descrip").toString():"";
		%>
		<table align="center" border="2">
			<input type="hidden" name="codigo" value="<%=cod%>">		
			<tr>
				<td>Nombre</td>
				<td>
					<input type="text" name="nombre" value="<%=nom%>">
				</td>
			</tr>
			<tr>
				<td>PrecioCompra</td>
				<td>
					<input type="text" name="precio" value="<%=pre%>">
				</td>
			</tr>
			<tr>
				<td>PrecioVenta</td>
				<td>
					<input type="text" name="precioVenta" value="<%=preVen%>">
				</td>
			</tr>
			<tr>
				<td>Estado</td>
				<td>
					<input type="text" name="estado" value="<%=est%>">
				</td>
			</tr>
			<tr>
				<td>Descripción</td>
				<td>
					<input type="text" name="descrip" value="<%=des%>">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Actualizar Producto">
				</td>
			</tr>
		</table>
	
	</form>

</body>
</html>