<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="#c5dec9">
	<h1 align="center">Ingresar al Sistema</h1>
	<form action="ControladorUsuario" method="post">
		<table border="2" align="center">
			<tr>
				<td>usuario</td>
				<td><input type="text" name="nombreUsuario" required></td>
			</tr>
			<tr>
				<td>password</td>
				<td><input type="password" name="contrasena" required></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Registrar"></td>
			</tr>
		</table>
	</form>
	    <%
        String error = request.getParameter("error");
        if (error != null && error.equals("1")) {
            out.println("<p style='color:red; text-align:center;'>Usuario o contraseña incorrectos.</p>");
        }
    	%>
</body>
</html>