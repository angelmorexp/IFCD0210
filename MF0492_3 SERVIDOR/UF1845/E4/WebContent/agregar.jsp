<%@page import="java.sql.*"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="new">

		<h2>Ingresar nuevo usuario</h2>
		<form id="nuevoUser" action="" method="POST">
			<table>
				<tr>
					<th>Usuario</th>
					<th>Contraseña</th>
					<th class="nom">Nombre</th>
					<th class="ape">Apellidos</th>
					<th>Edad</th>
					<th>Genero</th>
					<th>Estudiante</th>
					<th>Ocupacion</th>
					<th class="otr">Otros datos</th>
				</tr>
				<tr>
					<td><input type="text" name="usuario" id="usuario"></td>
					<td><input type="password" name="contraseña" id="contraseña"></td>
					<td><input type="text" name="nombre" id="nombre"></td>
					<td><input type="text" name="apellidos" id="apellidos"></td>
					<td><input type="number" name="edad" id="edad"></td>
					<td><select name="genero" form="nuevoUser" id="genero">
							<option value="NSNC">Prefiero no decirlo</option>
							<option value="Hombre">Hombre</option>
							<option value="Mujer">Mujer</option>
							<option value="NoBinario">No Binario</option>
					</select></td>
					<td><input type="checkbox" name="estudiante" id="estudiante"></td>
					<td><select name="ocupacion" form="nuevoUser" id="ocupacion">
							<option value="NSNC">Prefiero no decirlo</option>
							<option value="Desempleado">Desempleado</option>
							<option value="TrabajadorCP">Trabajador por cuenta
								propia</option>
							<option value="TrabajadorCA">Trabajador por cuenta ajena</option>
					</select></td>
					<td><input type="text" name="datos" id="datos"></td>
					<td><input type="submit" value="Registrar usuario" id="enviar" btn-lg></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>

<%
	//Conectar con la base de datos

	Connection con;
	String url = "jdbc:mysql://localhost:3306/uf1845-e4"; //Dirección de la base de datos (lo ultimo es el nombre de la BD)
	String driver = "com.mysql.jdbc.Driver";
	String usuario = "root"; //Usuario de la base de datos
	String contraseña = ""; //Contraseña de la base de datos
	Class.forName(driver);
	con = DriverManager.getConnection(url, usuario, contraseña);

	//Listar los datos de la base de datos

	PreparedStatement ps;

	Integer id = 1;
	String user = request.getParameter("usuario");
	String pass = request.getParameter("contraseña");
	String nombre = request.getParameter("nombre");
	String apellidos = request.getParameter("apellidos");
	Integer edad = Integer.parseInt(request.getParameter("edad"));
	String genero = request.getParameter("genero");
	Boolean estudiante = Boolean.parseBoolean(request.getParameter("estudiante"));
	String trabajador = request.getParameter("trabajador");
	String datos = request.getParameter("datos");

	if (user != null && pass != null && nombre != null && apellidos != null && edad != null){
		ps = con.prepareStatement(
				"insert into usuario(idUsuario,usuario, contraseña, nombre, apellidos, edad, genero, estudiante, ocupacion, otros)values('"
						+ id + "','" + user + "','" + pass + "','" + nombre + "','" + apellidos + "','" + edad
						+ "','" + genero + "','" + estudiante + "','" + trabajador + "','" + datos + "')");
	ps.executeUpdate();
	response.sendRedirect("index.jsp");
	}

%>