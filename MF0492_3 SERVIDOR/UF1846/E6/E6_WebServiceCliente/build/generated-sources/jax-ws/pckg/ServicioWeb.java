
package pckg;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicioWeb", targetNamespace = "http://pckg/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicioWeb {


    /**
     * 
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Saludo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Saludo", targetNamespace = "http://pckg/", className = "pckg.Saludo")
    @ResponseWrapper(localName = "SaludoResponse", targetNamespace = "http://pckg/", className = "pckg.SaludoResponse")
    @Action(input = "http://pckg/ServicioWeb/SaludoRequest", output = "http://pckg/ServicioWeb/SaludoResponse")
    public String saludo(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre);

    /**
     * 
     * @param fechaNacimiento
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "edad", targetNamespace = "http://pckg/", className = "pckg.Edad")
    @ResponseWrapper(localName = "edadResponse", targetNamespace = "http://pckg/", className = "pckg.EdadResponse")
    @Action(input = "http://pckg/ServicioWeb/edadRequest", output = "http://pckg/ServicioWeb/edadResponse")
    public String edad(
        @WebParam(name = "fecha_nacimiento", targetNamespace = "")
        int fechaNacimiento);

}
