/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pckg;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.JSONObject;

/**
 *
 * @author aula1
 */
@WebService(serviceName = "ServicioCalculadora")
public class ServicioCalculadora {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sumar")
    public String sumar(@WebParam(name = "n1") String n1, @WebParam(name = "n2") String n2) {
        
        JSONObject obj = new JSONObject();
        
        int nn1 = Integer.parseInt(n1);
        int nn2 = Integer.parseInt(n2);
        int suma = nn1+nn2;
        String result= Integer.toString(suma);
        
        //obj.put("result", result);
        obj.put("n1", n1);
        obj.put("n2", n2);
        obj.put("suma", result);
        String datos= obj.toJSONString();
        //TODO write your implementation code here:
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "restar")
    public String restar(@WebParam(name = "n1") String n1, @WebParam(name = "n2") String n2) {
        //TODO write your implementation code here:
        JSONObject obj = new JSONObject();
        
        int nn1 = Integer.parseInt(n1);
        int nn2 = Integer.parseInt(n2);
        int resta = nn1-nn2;
        String result= Integer.toString(resta);
        
        //obj.put("result", result);
        obj.put("n1", n1);
        obj.put("n2", n2);
        obj.put("resta", result);
        String datos= obj.toJSONString();
        //TODO write your implementation code here:
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "multiplicar")
    public String multiplicar(@WebParam(name = "n1") String n1, @WebParam(name = "n2") String n2) {
        //TODO write your implementation code here:
        JSONObject obj = new JSONObject();
        
        int nn1 = Integer.parseInt(n1);
        int nn2 = Integer.parseInt(n2);
        int producto = nn1*nn2;
        String result= Integer.toString(producto);
        
        //obj.put("result", result);
        obj.put("n1", n1);
        obj.put("n2", n2);
        obj.put("producto", result);
        String datos= obj.toJSONString();
        //TODO write your implementation code here:
        return datos;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "dividir")
    public String dividir(@WebParam(name = "n1") String n1, @WebParam(name = "n2") String n2) {
        //TODO write your implementation code here:
        JSONObject obj = new JSONObject();
        
        int nn1 = Integer.parseInt(n1);
        int nn2 = Integer.parseInt(n2);
        int division = nn1/nn2;
        String result= Integer.toString(division);
        
        //obj.put("result", result);
        obj.put("n1", n1);
        obj.put("n2", n2);
        obj.put("division", result);
        String datos= obj.toJSONString();
        //TODO write your implementation code here:
        return datos;
    }
}
