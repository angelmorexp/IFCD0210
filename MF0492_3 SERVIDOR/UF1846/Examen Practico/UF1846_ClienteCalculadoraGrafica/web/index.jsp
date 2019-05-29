<%-- 
    Document   : index
    Created on : 28-may-2019, 17:36:36
    Author     : aula1
--%>

<%@page import="org.json.simple.JSONValue"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Examen Práctico UF-1846</title>
        <link rel="stylesheet" type="text/css" href="./css/estilo.css">
        
        <script>
            
            var n1="";
            var n2="";
            var op=true;
            var oper= "";
            var npantalla;
            
            if (npantalla==null){
                npantalla="";
            }
            
            function addnumero(n,pantallaactual){
            
            npantalla= pantallaactual.concat(n);
            
            if(!op){
                n2= n2.concat(n);
            }
            else if (op===true && n===0 || n===1 || n===2 || n===3 || n===4 || n===5 || n===6 || n===7 || n===8 || n===9){
                n1= n1.concat(n);
            }
            else if(op===true){
                oper= n;
                op= false;
            }
            
            document.getElementById("pantalla").innerHTML = npantalla;
            
            console.log("ultimo pulsado="+n);
            console.log("en pantalla="+npantalla);
            console.log("numero1="+n1);
            console.log("op="+op);
            console.log("operacion="+oper);
            console.log("numero2="+n2);
            
            document.getElementById("n1").value = n1;
            document.getElementById("n2").value = n2;
            
            var accion;
            
            if (oper==="+"){
                accion = "opsumar";
            }
            else if (oper === "-"){
                accion = "oprestar";
            }
            else if (oper === "x"){
                accion = "opmultiplicar";
            }
            else if (oper === "÷"){
                accion = "opdividir";
            }
            
            document.getElementById("formulario").action = accion;
            
            return npantalla;
            return n1;
            return oper;
            return n2;
            return op;
            }
            
            function operacion(o){
                document.getElementById("botonsuma").disabled = true;
                document.getElementById("botonresta").disabled = true;
                document.getElementById("botonmultiplicacion").disabled = true;
                document.getElementById("botondivision").disabled = true;
            }
            
            function borrar(){
                
                n1="";
                n2="";
                op=true;
                oper= "";
                npantalla="";
                
                document.getElementById("botonsuma").disabled = false;
                document.getElementById("botonresta").disabled = false;
                document.getElementById("botonmultiplicacion").disabled = false;
                document.getElementById("botondivision").disabled = false;
                document.getElementById("pantalla").innerHTML = npantalla;
                
                return n1;
                return n2;
                return op;
                return oper;
                return npantalla;
            }
            
        </script>
            
    </head>
    <body>
        <h1>Calculadora</h1>
        <div id="cuerpo">
            <div id="pantalla">
                
                <% String valor= (String)request.getAttribute("pantallai"); 
                    if (valor==null){
                        valor="";
                    }
                    
                    String paquete= (String) request.getAttribute("paquete");
                    if (paquete==null){
                        paquete="";
                    }
                    JSONObject miobjeto = (JSONObject)JSONValue.parse(paquete);
                %>
                <%= valor %>
            </div>
            <div id="numeros">
                <table>
                    <tr>
                        <td><button type="button" onclick="addnumero(7, npantalla)">7</button></td>
                        <td><button type="button" onclick="addnumero(8, npantalla);">8</button></td>
                        <td><button type="button" onclick="addnumero(9, npantalla);">9</button></td>
                    </tr>
                    <tr>
                        <td><button type="button" onclick="addnumero(4, npantalla);">4</button></td>
                        <td><button type="button" onclick="addnumero(5, npantalla);">5</button></td>
                        <td><button type="button" onclick="addnumero(6, npantalla);">6</button></td>
                    </tr>
                    <tr>
                        <td><button type="button" onclick="addnumero(1, npantalla);">1</button></td>
                        <td><button type="button" onclick="addnumero(2, npantalla);">2</button></td>
                        <td><button type="button" onclick="addnumero(3, npantalla);">3</button></td>
                    </tr>
                    <tr>
                        <td id="cero" rowspan="2" ><button type="button" onclick="addnumero(0, npantalla);">0</button></td>
                        <td id="borrar" rowspan="1"><button type="button" onclick="borrar(n1,n2,op,oper,npantalla);">↩</button></td>
                    </tr>
                </table>
            </div>
            <div id="operaciones">
                <table>
                <tr>
                    <td><button id="botonsuma" type="button" onclick="addnumero('+', npantalla);operacion('+')">+</button></td>
                </tr>
                <tr>
                    <td><button id="botonresta"  type="button" onclick="addnumero('-', npantalla);operacion('-')">-</button></td>
                </tr>
                <tr>
                    <td><button id="botonmultiplicacion"  type="button" onclick="addnumero('x', npantalla);operacion('x')">x</button></td>
                </tr>
                <tr>
                    <td><button id="botondivision"  type="button" onclick="addnumero('÷', npantalla);operacion('÷')">÷</button></td>
                </tr>
                <tr>
                <form  id="formulario" action="" method="POST">
                    <input style="display:none;" id="n1" name="n1" type="text">
                    <input style="display:none;" id="n2" name="n2" type="text">
                    <td><button type="submit" id="enviar" form="formulario">=</button></td>
                </form>
                
                </tr>
                </table>
            </div>
        </div>
    </body>
</html>
