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
<title>Añadir Nuevo Usuario</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
</head>
<body>

	<div id="new">

		<h2>Ingresar nuevo usuario</h2>
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
					<td><input type="submit" value="Registrar usuario" id="enviar"></td>
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

	ResultSet rs;
	ps = con.prepareStatement("select * from usuario");
	rs = ps.executeQuery();

	Integer  edad, estudiante, disponible;
	String userExist, user, pass, nombre, apellidos, genero, ocupacion, datos;
	Boolean estudianteb ;

	user = request.getParameter("usuario");
	disponible = 0;
	
	
	PreparedStatement ps1;
	ResultSet rs1;
	ps1 = con.prepareStatement("select * from usuario where usuario='"+user+"'");
	rs1 = ps1.executeQuery();
	
	while (rs1.next()){
		disponible++;
	}
	
	if (disponible == 0){	
	
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
			ps = con.prepareStatement(
					"insert into usuario(usuario, contraseña, nombre, apellidos, edad, genero, estudiante, ocupacion, otros)values('" + user + "','" + pass + "','" + nombre + "','" + apellidos + "','"
							+ edad + "','" + genero + "','" + estudiante + "','" + ocupacion + "','" + datos
							+ "')");
			ps.executeUpdate();
			response.sendRedirect("index.jsp");
		}
		else {
			%><script type="text/javascript">
			alert("Alguno de los campos se encuentra vacío");
			</script><%
		}
	}
	else {
		%><script type="text/javascript">
		alert("Este usuario ya existe");
		</script><%
	}
		
%>