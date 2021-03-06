
package stubs.customerCare;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "AlreadyExistingCustomerException", targetNamespace = "http://webservice.tcf.isa.polytech.unice.fr/")
public class AlreadyExistingCustomerException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private AlreadyExistingCustomerException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public AlreadyExistingCustomerException_Exception(String message, AlreadyExistingCustomerException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public AlreadyExistingCustomerException_Exception(String message, AlreadyExistingCustomerException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: stubs.customerCare.AlreadyExistingCustomerException
     */
    public AlreadyExistingCustomerException getFaultInfo() {
        return faultInfo;
    }

}
