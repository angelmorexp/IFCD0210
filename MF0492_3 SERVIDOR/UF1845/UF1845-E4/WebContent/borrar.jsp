<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Borrar Registro</title>
</head>
<body>
<% 
Connection con;
		String url = "jdbc:mysql://localhost:3306/uf1845-e4"; //Direcci�n de la base de datos (lo ultimo es el nombre de la BD)
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root"; //Usuario de la base de datos
		String contrase�a = ""; //Contrase�a de la base de datos
		Class.forName(driver);
		con = DriverManager.getConnection(url, usuario, contrase�a);

		//Listar los datos de la base de datos

		PreparedStatement ps;
		ResultSet rs;
		int idUsuario=Integer.parseInt(request.getParameter("id"));
		
		ps = con.prepareStatement("delete from usuario where idUsuario="+idUsuario);
		ps.executeUpdate();
		response.sendRedirect("index.jsp");
		
		%>
</body>
</html>