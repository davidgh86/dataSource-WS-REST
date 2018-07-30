package com.ust.datasource.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;

@WebService(targetNamespace = "http://service.ws.sample/", name = "Hello")
public interface DataOperation {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHello",
        targetNamespace = "http://service.ws.sample/",
        className = "sample.ws.service.SayHello")
    @WebMethod(action = "urn:SayHello")
    @ResponseWrapper(localName = "sayHelloResponse",
        targetNamespace = "http://service.ws.sample/",
        className = "sample.ws.service.SayHelloResponse")
    Data createData(@WebParam(name = "data", targetNamespace = "") Data data);

    @WebResult
    @RequestWrapper
    @WebMethod
    @ResponseWrapper
    Data readData(@WebParam(name = "id") String id);

    @WebResult
    @RequestWrapper
    @WebMethod
    @ResponseWrapper
    List<Data> findByName(@WebParam(name = "name") String name);

    @WebResult
    @RequestWrapper
    @WebMethod
    @ResponseWrapper
    Data findByDni(@WebParam(name = "dni") String dni);

    @WebResult
    @RequestWrapper
    @WebMethod
    @ResponseWrapper
    Data update(Data data);

    @WebResult
    @RequestWrapper
    @WebMethod
    @ResponseWrapper
    void delete(@WebParam(name = "id") String id);

    @WebResult
    @RequestWrapper
    @WebMethod
    @ResponseWrapper
    List<Data> findAll();

}
