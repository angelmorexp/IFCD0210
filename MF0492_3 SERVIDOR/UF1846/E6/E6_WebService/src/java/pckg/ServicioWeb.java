/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckg;

import java.util.Calendar;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author aula1
 */
@WebService(serviceName = "ServicioWeb")
public class ServicioWeb {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Saludo")
    public String Saludo(@WebParam(name = "nombre") String nombre) {
        //TODO write your implementation code here:
        return "Bienvenido " + nombre;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "edad")
    public String edad(@WebParam(name = "fecha_nacimiento") int fecha_nacimiento) {
        
        int ahora = Calendar.getInstance().get(Calendar.YEAR);
        int edad = (ahora - fecha_nacimiento);
        
        return Integer.toString(edad);
    }

}
