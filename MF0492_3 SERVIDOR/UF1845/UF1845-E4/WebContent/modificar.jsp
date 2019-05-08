<%@page import="java.sql.*"%>
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
<title>Modificar Usuario</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>
	<%
		Connection con;
		String url = "jdbc:mysql://localhost:3306/uf1845-e4"; //Dirección de la base de datos (lo ultimo es el nombre de la BD)
		String driver = "com.mysql.jdbc.Driver";
		String usuario = "root"; //Usuario de la base de datos
		String contraseña = ""; //Contraseña de la base de datos
		Class.forName(driver);
		con = DriverManager.getConnection(url, usuario, contraseña);

		//Listar los datos de la base de datos

		PreparedStatement ps;
		ResultSet rs;
		int idUsuario = Integer.parseInt(request.getParameter("id"));
		
		ps = con.prepareStatement("select * from usuario where idUsuario="+idUsuario);
		rs = ps.executeQuery();
		while (rs.next())  {
	%>
	<div id="new">

		<h2>Modificar usuario</h2>
		<form id="nuevoUser" action="" method="POST">
			<table>
				<tr>
					<th id="id">Usuario</th>
					<th>Contraseña</th>
					<th class="nom">Nombre</th>
					<th class="ape">Apellidos</th>
					<th>Edad</th>
					<th>Genero</th>
					<th>Estudiante</th>
					<th>Ocupacion</th>
					<th class="otr">Otros datos</th>
					<th id="esp"><a id="volver" href="index.jsp">Volver</a></th>
				</tr>
				<tr>
					<td><input type="text" name="usuario" id="usuario" readonly="" value="<%=rs.getString("usuario")%>"></td>
					<td><input type="password" name="contraseña" id="contraseña" value="<%=rs.getString("contraseña")%>"></td>
					<td><input type="text" name="nombre" id="nombre" value="<%=rs.getString("nombre")%>"></td>
					<td><input type="text" name="apellidos" id="apellidos" value="<%=rs.getString("apellidos")%>"></td>
					<td><input type="number" name="edad" id="edad" value="<%=rs.getInt("edad")%>"></td>
					<td><select name="genero" form="nuevoUser" id="genero">
							<option value="NSNC" <% if (rs.getString("genero").equals("NSNC")){ %> selected <% } %>>Prefiero no decirlo</option>
							<option value="Hombre"<% if (rs.getString("genero").equals("Hombre")){ %> selected <% } %>>Hombre</option>
							<option value="Mujer" <% if (rs.getString("genero").equals("Mujer")){ %> selected <% } %>>Mujer</option>
							<option value="NoBinario" <% if (rs.getString("genero").equals("NoBinario")){ %> selected <% } %>>No Binario</option>
					</select></td>
					<td><input type="checkbox" name="estudiante" id="estudiante" <% if (rs.getBoolean("estudiante") == true){ %> checked <% } %>></td>
					<td><select name="ocupacion" form="nuevoUser" id="ocupacion">
							<option value="NSNC" <% if (rs.getString("ocupacion").equals("NSNC")){ %> selected <% } %>>Prefiero no decirlo</option>
							<option value="Desempleado" <% if (rs.getString("ocupacion").equals("Desempleado")){ %> selected <% } %>>Desempleado</option>
							<option value="TrabajadorCP" <% if (rs.getString("ocupacion").equals("TrabajadorCP")){ %> selected <% } %>>Trabajador por cuenta
								propia</option>
							<option value="TrabajadorCA" <% if (rs.getString("ocupacion").equals("TrabajadorCA")){ %> selected <% } %>>Trabajador por cuenta ajena</option>
					</select></td>
					<td><input type="text" name="datos" id="datos" value="<%=rs.getString("otros")%>"></td>
					<td><input type="submit" value="Guardar Cambios" id="enviar"></td>
				</tr>
			</table>
		</form>
	</div>
		</table>
	</div>
	<% } %>
</body>
</html>
<%
Integer edad, estudiante, disponible;
String user, pass, nombre, apellidos, genero, ocupacion, datos;
Boolean estudianteb ;

	
	user = request.getParameter("usuario");
	pass = request.getParameter("contraseña");
	nombre = request.getParameter("nombre");
	apellidos = request.getParameter("apellidos");

	try {
		edad = Integer.parseInt(request.getParameter("edad"));
	} catch (Exception e) {
		edad = 0;
	}

	genero = request.getParameter("genero");
	

	if (request.getParameter("estudiante")!= null) {
		estudiante = 1;
	} else {
		estudiante = 0;
	}

	ocupacion = request.getParameter("ocupacion");
	datos = request.getParameter("datos");

	if (user != null && pass != null && nombre != null && apellidos != null && edad != null
			&& genero != null && ocupacion != null && datos != null && user != "" && pass != "" && nombre != "" && apellidos != "" && edad != 0
			&& genero != "" && ocupacion != "" && datos != "") {
		ps = con.prepareStatement("update usuario set contraseña='"+pass+"', nombre='" + nombre + "', apellidos='" + apellidos + "', edad='"+ edad + "',genero='" + genero + "', estudiante='" + estudiante + "', ocupacion='" + ocupacion + "', otros='" + datos+ "' where idUsuario="+idUsuario);
			
		ps.executeUpdate();
		response.sendRedirect("index.jsp");
	}


%>