<%-- 
    Document   : index
    Created on : 21-may-2019, 19:36:10
    Author     : aula1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>E6 Web Service</title>
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">
    </head>
    <body>
        <div id="content">
        <h1>E6 - Cliente Web Service </h1>
        
         <form action="action.jsp" method="POST">
             <table>
                 <tr>
                     <td>Indicar nombre:</td>
                     <td><input type="text" name="nombre"></td>
                     <td><input type="submit" value="Enviar datos"></td>
                 </tr>
             </table>
        </form>
        <form action="action1.jsp" method="POST">
            <table>
                <tr>
                    <td>Indicar año de nacimiento:</td>
                    <td><input type="text" name="anno"></td>
                    <td><input type="submit" value="Enviar datos"></td>
                </tr>
            </table>
        </form>
        </div>
    </body>
</html>
