<%-- 
    Document   : action
    Created on : 21-may-2019, 19:37:31
    Author     : aula1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Service: saludo</title>
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    </head>
    <body>
        <div id="content">
        <h1>E6 - Web Service</h1>
        <h2>Saludo</h2>
       
    <%-- start web service invocation --%><hr/>
    <%
        String nombre1 = request.getParameter("nombre");
    try {
	pckg.ServicioWeb_Service service = new pckg.ServicioWeb_Service();
	pckg.ServicioWeb port = service.getServicioWebPort();
	 // TODO initialize WS operation arguments here
	java.lang.String nombre = nombre1;
	// TODO process result here
	java.lang.String result = port.saludo(nombre);
	out.println(result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
        </div>
    </body>
</html>
