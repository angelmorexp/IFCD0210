
package pckg;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pckg package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Saludo_QNAME = new QName("http://pckg/", "Saludo");
    private final static QName _SaludoResponse_QNAME = new QName("http://pckg/", "SaludoResponse");
    private final static QName _Edad_QNAME = new QName("http://pckg/", "edad");
    private final static QName _EdadResponse_QNAME = new QName("http://pckg/", "edadResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pckg
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Saludo }
     * 
     */
    public Saludo createSaludo() {
        return new Saludo();
    }

    /**
     * Create an instance of {@link SaludoResponse }
     * 
     */
    public SaludoResponse createSaludoResponse() {
        return new SaludoResponse();
    }

    /**
     * Create an instance of {@link Edad }
     * 
     */
    public Edad createEdad() {
        return new Edad();
    }

    /**
     * Create an instance of {@link EdadResponse }
     * 
     */
    public EdadResponse createEdadResponse() {
        return new EdadResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Saludo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pckg/", name = "Saludo")
    public JAXBElement<Saludo> createSaludo(Saludo value) {
        return new JAXBElement<Saludo>(_Saludo_QNAME, Saludo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaludoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pckg/", name = "SaludoResponse")
    public JAXBElement<SaludoResponse> createSaludoResponse(SaludoResponse value) {
        return new JAXBElement<SaludoResponse>(_SaludoResponse_QNAME, SaludoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Edad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pckg/", name = "edad")
    public JAXBElement<Edad> createEdad(Edad value) {
        return new JAXBElement<Edad>(_Edad_QNAME, Edad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EdadResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://pckg/", name = "edadResponse")
    public JAXBElement<EdadResponse> createEdadResponse(EdadResponse value) {
        return new JAXBElement<EdadResponse>(_EdadResponse_QNAME, EdadResponse.class, null, value);
    }

}
