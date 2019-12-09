/**
 * WsGetInfSorteoLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.uv.dsia.webservices;

public class WsGetInfSorteoLocator extends org.apache.axis.client.Service implements mx.uv.dsia.webservices.WsGetInfSorteo {

    public WsGetInfSorteoLocator() {
    }


    public WsGetInfSorteoLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsGetInfSorteoLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for wsGetInfSorteoSoap
    private java.lang.String wsGetInfSorteoSoap_address = "http://dsia.uv.mx/WSPortal/wsSistemas/wsSorteoUV/wsGetInfSorteo.asmx";

    public java.lang.String getwsGetInfSorteoSoapAddress() {
        return wsGetInfSorteoSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wsGetInfSorteoSoapWSDDServiceName = "wsGetInfSorteoSoap";

    public java.lang.String getwsGetInfSorteoSoapWSDDServiceName() {
        return wsGetInfSorteoSoapWSDDServiceName;
    }

    public void setwsGetInfSorteoSoapWSDDServiceName(java.lang.String name) {
        wsGetInfSorteoSoapWSDDServiceName = name;
    }

    public mx.uv.dsia.webservices.WsGetInfSorteoSoap getwsGetInfSorteoSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wsGetInfSorteoSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwsGetInfSorteoSoap(endpoint);
    }

    public mx.uv.dsia.webservices.WsGetInfSorteoSoap getwsGetInfSorteoSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.uv.dsia.webservices.WsGetInfSorteoSoapStub _stub = new mx.uv.dsia.webservices.WsGetInfSorteoSoapStub(portAddress, this);
            _stub.setPortName(getwsGetInfSorteoSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwsGetInfSorteoSoapEndpointAddress(java.lang.String address) {
        wsGetInfSorteoSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.uv.dsia.webservices.WsGetInfSorteoSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.uv.dsia.webservices.WsGetInfSorteoSoapStub _stub = new mx.uv.dsia.webservices.WsGetInfSorteoSoapStub(new java.net.URL(wsGetInfSorteoSoap_address), this);
                _stub.setPortName(getwsGetInfSorteoSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("wsGetInfSorteoSoap".equals(inputPortName)) {
            return getwsGetInfSorteoSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://dsia.uv.mx/webservices/", "wsGetInfSorteo");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://dsia.uv.mx/webservices/", "wsGetInfSorteoSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("wsGetInfSorteoSoap".equals(portName)) {
            setwsGetInfSorteoSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
