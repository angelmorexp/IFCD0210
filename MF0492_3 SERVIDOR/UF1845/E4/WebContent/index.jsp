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
<title>CRUD USUARIOS</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<script type="text/javascript">

</script>
</head>
<body>
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

		//Se crea la tabla
	%>

	<div id="content">
	<h2>Lista de Usuarios</h2>
		<table>
			<tr>
				<th id="id">Id</th>
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
			<%
				while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("idUsuario")%></td>
				<td><%=rs.getString("usuario")%></td>
				<td><%=rs.getString("contraseña")%></td>
				<td><%=rs.getString("nombre")%></td>
				<td><%=rs.getString("apellidos")%></td>
				<td><%=rs.getInt("edad")%></td>
				<td><%=rs.getString("genero")%></td>
				<td><%=rs.getBoolean("estudiante")%></td>
				<td><%=rs.getString("ocupacion")%></td>
				<td><%=rs.getString("otros")%></td>
				<td class="del"><button>&#x2716;</button></td>
				<td class="mod"><button>&#x270E;</button></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
	<h2><a href="agregar.jsp">Ingresar nuevo usuario</a></h2>
	

</body>
</html>