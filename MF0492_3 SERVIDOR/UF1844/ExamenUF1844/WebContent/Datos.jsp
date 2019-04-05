<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Sus datos</title>
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
function enviar(){
var boton= document.getElementById("enviar");
boton.style.display ="none";

var element= document.getElementsByClassName("gen");
for (var i=0; i < element.length; i++) {
    element[i].onclick = function(){
        return false;
    }
};

}

function editar(){
var boton= document.getElementById("enviar");
boton.style.display ="inline-block";
document.getElementById("passwordreg").removeAttribute('readonly');
document.getElementById("nombre").removeAttribute('readonly');
document.getElementById("apellidos").removeAttribute('readonly');
document.getElementById("textbox").removeAttribute('readonly');

var element= document.getElementsByClassName("gen");
for (var i=0; i < element.length; i++) {
    element[i].onclick = function(){
        return true;
    }
};

}
</script>
</head>
<body onload="enviar();">
	
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
			<input type="text" name="nombre" id="nombre" value="" readonly>
			<label>Apellidos</label>
			<input type="text" name="apellidos" id="apellidos" value="" readonly>
			<label id="gene">Genero</label>
			<input class="gen" type="radio" name="genero" value="Hombre" >Hombre<br>
			<input class="gen" type="radio" name="genero" value="Mujer" >Mujer<br>
			<input class="gen" type="radio" name="genero" value="NoBinario" >No Binario<br>
			</div>
			<div id="datos2">
			<label id="ocupacion">Ocupación</label>
			<input class="gen" type="checkbox" name="ocupacion" value="Estudiante" >Estudiante<br>
			<input class="gen" type="checkbox" name="ocupacion" value="Trabajador" >Trabajador<br>
				<input id="secret" class="gen" type="checkbox" name="ocupacion" value=" " checked readonly><br>
			<label id="otros">Otros datos</label>
			<textarea id="textbox" name="mensaje" rows="7" cols="20" readonly >"Introduzca otros datos aquí"</textarea>
			</div>
			
			<button type="button" onclick="editar();">Editar</button>
			<input type="submit" value="Enviar datos" id="enviar" >

		</form>

	</div>

</body>
</html>