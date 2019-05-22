<%-- 
    Document   : action1
    Created on : 21-may-2019, 19:53:36
    Author     : aula1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Service : edad</title>
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    </head>
    <body>
        <div id="content">
        <h1>E6 - Web Service</h1>
        <h2>Edad</h2>
    <%-- start web service invocation --%><hr/>
    <%
    try {
        String año = request.getParameter("anno");
        int fecha = Integer.parseInt(año);
        
	pckg.ServicioWeb_Service service = new pckg.ServicioWeb_Service();
	pckg.ServicioWeb port = service.getServicioWebPort();
	 // TODO initialize WS operation arguments here
	int fechaNacimiento = fecha;
	// TODO process result here
	java.lang.String result = port.edad(fechaNacimiento);
	out.println("Usted tiene "+result+" años si su cumpleaños ya ha sido este año.");
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
        </div>
    </body>
</html>
