package mx.uv.dsia.webservices;

public class WsGetInfSorteoSoapProxy implements mx.uv.dsia.webservices.WsGetInfSorteoSoap {
  private String _endpoint = null;
  private mx.uv.dsia.webservices.WsGetInfSorteoSoap wsGetInfSorteoSoap = null;
  
  public WsGetInfSorteoSoapProxy() {
    _initWsGetInfSorteoSoapProxy();
  }
  
  public WsGetInfSorteoSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsGetInfSorteoSoapProxy();
  }
  
  private void _initWsGetInfSorteoSoapProxy() {
    try {
      wsGetInfSorteoSoap = (new mx.uv.dsia.webservices.WsGetInfSorteoLocator()).getwsGetInfSorteoSoap();
      if (wsGetInfSorteoSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsGetInfSorteoSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsGetInfSorteoSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsGetInfSorteoSoap != null)
      ((javax.xml.rpc.Stub)wsGetInfSorteoSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.uv.dsia.webservices.WsGetInfSorteoSoap getWsGetInfSorteoSoap() {
    if (wsGetInfSorteoSoap == null)
      _initWsGetInfSorteoSoapProxy();
    return wsGetInfSorteoSoap;
  }
  
  public java.lang.String sorteoUV(java.lang.String fecha) throws java.rmi.RemoteException{
    if (wsGetInfSorteoSoap == null)
      _initWsGetInfSorteoSoapProxy();
    return wsGetInfSorteoSoap.sorteoUV(fecha);
  }
  
  
}