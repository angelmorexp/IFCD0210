
package pckg;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServicioCalculadora", targetNamespace = "http://pckg/", wsdlLocation = "http://localhost:8080/UF1846_ServidorCalculadoraGrafica/ServicioCalculadora?wsdl")
public class ServicioCalculadora_Service
    extends Service
{

    private final static URL SERVICIOCALCULADORA_WSDL_LOCATION;
    private final static WebServiceException SERVICIOCALCULADORA_EXCEPTION;
    private final static QName SERVICIOCALCULADORA_QNAME = new QName("http://pckg/", "ServicioCalculadora");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/UF1846_ServidorCalculadoraGrafica/ServicioCalculadora?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOCALCULADORA_WSDL_LOCATION = url;
        SERVICIOCALCULADORA_EXCEPTION = e;
    }

    public ServicioCalculadora_Service() {
        super(__getWsdlLocation(), SERVICIOCALCULADORA_QNAME);
    }

    public ServicioCalculadora_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOCALCULADORA_QNAME, features);
    }

    public ServicioCalculadora_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOCALCULADORA_QNAME);
    }

    public ServicioCalculadora_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOCALCULADORA_QNAME, features);
    }

    public ServicioCalculadora_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioCalculadora_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioCalculadora
     */
    @WebEndpoint(name = "ServicioCalculadoraPort")
    public ServicioCalculadora getServicioCalculadoraPort() {
        return super.getPort(new QName("http://pckg/", "ServicioCalculadoraPort"), ServicioCalculadora.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioCalculadora
     */
    @WebEndpoint(name = "ServicioCalculadoraPort")
    public ServicioCalculadora getServicioCalculadoraPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://pckg/", "ServicioCalculadoraPort"), ServicioCalculadora.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOCALCULADORA_EXCEPTION!= null) {
            throw SERVICIOCALCULADORA_EXCEPTION;
        }
        return SERVICIOCALCULADORA_WSDL_LOCATION;
    }

}