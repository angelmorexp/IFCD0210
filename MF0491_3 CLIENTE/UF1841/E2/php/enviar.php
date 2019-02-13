<?php

 
    // Creamos el header para el mensaje
 
    // para:
 
    $to = $_POST['email'];
 
    // Asunto
 
    $subject = $_POST['asunto'];
 
    // Cabeceras del mail (Content-Type y demas info)
 
    $headers = "MIME-Version: 1.0\r\n";
 
    $headers .= "Content-type: text/html; charset=iso-8859-1\r\n";
 
    // El From: en la forma Nombre <email@sitio.com>, esto garantiza que
 
    // el receptor vea solo el nombre de quien envia
 
    $headers .= "From: ".$_POST['nombre']." <".$_POST['email'].">\r\n";
 
    // Opcional: Resopnder a:
 
    $headers .= "Reply-To: " . $_POST['email']."\r\n";
 
    //Opcional X-Mailer
 
    $headers .= "X-Mailer: PHP/" . phpversion();
 
// Cuerpo del email
	
	 // Cuerpo del mensaje
    $cabecera = "---------------------------------- \n";
    $cabecera.= "     Datos del cliente           \n";
    $cabecera.= "----------------------------------" . '<br>';
	$cabecera.= "NOMBRE Y APELLIDOS:   ".$_POST['nombre'].$_POST['apellidos']. '<br>';
	$cabecera.= "EMAIL:  ".$_POST['email']. '<br>';
	$cabecera.= "MENSAJE :   ".$_POST['mensaje']. '<br>';
	
	$message3 = utf8_decode($cabecera);
 
    // $message = $_POST['message'];
	// $cabecera = "Nombre | Apellido | email |";
	// $datos1 = "| " . $_POST['nombre'] . "| " .  $_POST['apellido'] .  "| "  . $_POST['email'];
	// $message3 = $cabecera . "   " .  $datos1 . $datos2 . $datos3  . "| MENSAJE " . $message ;
	
	$subject =  $nombre . "He recibido sus datos ";
	$message2 = "Muchas gracias por contactar con nosotros, nos pondremos en contacto via email con usted en la mayor brevedad posible.<br/><br />
        Muchas gracias, <br /><br />
        Angel Morales Expósito.";
		
	$to1 = "angelmorexp@gmail.com";
	$subject1 = "Datos de  " . $_POST['nombre'];
	
 
    if(mail($to, $subject, $message2,$headers))
     {
      echo "<b>Mensaje enviado, Gracias por las sugerencias.</b><br/><a href=\"javascript:history.go(-1)\">RETORNA</a>";
	  mail($to1, $subject1, $message3,$headers);
      // echo <a href="http://acrosseurope.org/test/test.html" target="_blank">Placement test</a>
	  }
    
 
   
 
?>