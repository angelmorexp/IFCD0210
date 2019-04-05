<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Formulario de Ingreso</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

function validarDatos() {
	
	var usuario = document.getElementById("usuarioreg");
	var password = document.getElementById("passwordreg");
	var password2 = document.getElementById("password2reg");
	
	if (usuario.value == ""){
		alert("Debe introducir un nombre de usuario");
		return false;
	}

	if (password.value == ""){
		alert("Debe introducir una contraseña");
		return false;
	}
	
	if (password.value != password2.value){
		alert("La contraseña no coincide");
		return false;
	}
	else {
		return true;
		
	}
}
function check() {
	var usuario = document.getElementById("usuarioreg").value;
	var direccion = "'http://localhost:8080/ExamenUF1844/usuarios/"+usuario+".html'" ;
	
	$.ajax({
		
        url: 'http://localhost:8080/ExamenUF1844/usuarios/'+usuario+'.html',
        async: false ,
        
        error: function()
        {
           var mensaje= "Nombre de usuario disponible";
           document.getElementById('comprobar').style.fontSize = "10px";
           document.getElementById('comprobar').style.color = "red";
           document.getElementById('comprobar').style.marginTop = "-12px";
           document.getElementById('comprobar').innerHTML = mensaje;
        },
        success: function()
        {
            var mensaje= "Nombre de usuario no disponible";
            return mensaje;
            document.getElementById('comprobar').innerHTML = mensaje;
        }
    });
	document.getElementById('test').innerHTML = direccion;
}

</script>
</head>
<body>
	
	<div>
	<label id="test"></label>
		<img id="usericon" src="images/user.png">
	
		<span id="log">Login</span>
		<span id="sign">Sign in</span>
		
		<form id="Login" action="VerDatos_Servlet" method="POST">

			<label>Usuario</label>
			<input type="text" name="usuariolog" id="usuariolog" value="usuario">
			<label>Contraseña</label>
			<input type="password" name="passwordlog" id="passwordlog" value="contraseña">
			<input type="submit" value="Entrar" id="entrar" onclick="this.form.action='VerDatos_Servlet';">

		</form>

		<form id="Registro" action="Registro" method="POST" onsubmit="return validarDatos();">

			<label>Usuario</label>
			<input type="text" name="usuarioreg" id="usuarioreg" value="usuario" onkeyup="check();">
			<label id="comprobar"></label>
			<label>Contraseña</label>
			<input type="password" name="passwordreg" id="passwordreg" value="contraseña">
			<label>Repita Contraseña</label>
			<input type="password" name="password2reg" id="password2reg" value="contraseña">
			<input type="submit" value="Registrarse" id="registrarse" onclick="this.form.action='Registro';" >

		</form>

	</div>

</body>
</html>