<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<link rel="stylesheet" type="text/css" href="css/registrojsp.css">
<script type="text/javascript">
function mostrar(){
	document.getElementById("passwordreg").type="text";
	document.getElementById("passwordreg").style.fontSize="14px"
	return false;
}
function ocultar(){
	document.getElementById("passwordreg").type="password";
	document.getElementById("passwordreg").style.fontSize="13px"
	return false;
}

</script>
</head>
<body>
	
	<div>
	
	<h1>Rellene los campos del formulario, gracias.</h1>
		
		<form id="Formulario" action="Datos_Servlet" method="POST">
			<div id="user">
			<label>Usuario</label>
			<input type="text" name="usuarioreg" id="usuarioreg" value=<%= request.getAttribute("usuarioSign") %> readonly >
			</div>
			<div id="pass">
			<label>Contraseña</label>
			<input type="password" name="passwordreg" id="passwordreg" value=<%= request.getAttribute("contraseñaSign") %> readonly>
			<button id="ojo" type="button" onmouseover="mostrar();" onmouseout="ocultar();"></button>
			</div>
			<div id="datos1">
			<label>Nombre</label>
			<input type="text" name="nombre" id="nombre" value="">
			<label>Apellidos</label>
			<input type="text" name="apellidos" id="apellidos" value="">
			<label id="gene">Genero</label>
			<input class="gen" type="radio" name="genero" value="Hombre">Hombre<br>
			<input class="gen" type="radio" name="genero" value="Mujer">Mujer<br>
			<input class="gen" type="radio" name="genero" value="NoBinario">No Binario<br>
			</div>
			<div id="datos2">
			<label id="ocupacion">Ocupación</label>
			<input class="gen" type="checkbox" name="ocupacion" value="Estudiante">Estudiante<br>
			<input class="gen" type="checkbox" name="ocupacion" value="Trabajador">Trabajador<br>
			<input id="secret" class="gen" type="checkbox" name="ocupacion" value=" " checked readonly><br>
			<label id="otros">Otros datos</label>
			<textarea name="mensaje" rows="7" cols="20">Introduzca otros datos aquí</textarea>
			</div>
			
			<input type="submit" value="Enviar datos" id="enviar">

		</form>

	</div>

</body>
</html>