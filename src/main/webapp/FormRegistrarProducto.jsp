<%@page import="Dao.ClassProductoImp"%>
<%@page import="model.TblProductocl3"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center"> Registrar Producto</h1>
<form action="ControladorProducto" method="post">
	<table border="2" align="center">
	<tr>
	<td>Nombre</td>
	<td><input type="text" name="nombre"></td>
	</tr>
	<tr>
	<td>Precio</td>
	<td><input type="number" name="precio"></td>
	</tr>
	<tr>
	<td>PrecioVen</td>
	<td><input type="number" name="precioVenta"></td>
	</tr>
	<tr>
	<td>Estado</td>
	<td><input type="text" name="estado"></td>
	</tr>
	<tr>
	<td>Descrip</td>
	<td><input type="text" name="descrip"></td>
	</tr>
	<tr>
	<td  align="center" colspan="2">
	<input type="submit" value="Registrar">
	</td>
	</tr>
	</table>
</form>
		<% String mensaje = (String) request.getAttribute("mensaje"); %>
	    <% if (mensaje != null && !mensaje.isEmpty()) { %>
	        <p align="center" color="blue"><%= mensaje %></p>
	
	    <% } %>

    <% ClassProductoImp crud = new  ClassProductoImp();%>
    
            	<h2 align="center">Listado de Productos</h2>
    <table border="2"  align="center">
		<tr>
			<td>Codigo</td>
			<td>Nom</td>
			<td>pv</td>
			<td>pc</td>
			<td>Est.</td>
			<td>Des.</td>
			<td colspan="2">Acciones</td>
		</tr>
		<%
			List<TblProductocl3> listadoProducto = (List<TblProductocl3>)request.getAttribute("listadoproductos");
			if(listadoProducto != null){
				for(TblProductocl3 li : listadoProducto){
				%>
					<tr>
						<td><%=li.getIdproductoscl3()%></td>
						<td><%=li.getNombrecl3()%></td>
						<td><%=li.getPrecioventacl3()%></td>
						<td><%=li.getPreciocompcl3()%></td>
						<td><%=li.getEstadocl3()%></td>
						<td><%=li.getDescripcl3()%></td>
						<td><a href="ControladorProducto?accion=Eliminar&cod=<%=li.getIdproductoscl3()%>">Borrar</a></td>
						<td><a href="ControladorProducto?accion=Modificar&cod=<%=li.getIdproductoscl3()%>">Actua</a></td>
					</tr>
				<% 	
				}
			}
		%>
		
	</table>
</form>
</body>
</html>