
package chatserver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "UsersManager", targetNamespace = "http://chatserver/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UsersManager {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "connect", targetNamespace = "http://chatserver/", className = "chatserver.Connect")
    @ResponseWrapper(localName = "connectResponse", targetNamespace = "http://chatserver/", className = "chatserver.ConnectResponse")
    public Integer connect(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "disconnect", targetNamespace = "http://chatserver/", className = "chatserver.Disconnect")
    @ResponseWrapper(localName = "disconnectResponse", targetNamespace = "http://chatserver/", className = "chatserver.DisconnectResponse")
    public void disconnect(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
