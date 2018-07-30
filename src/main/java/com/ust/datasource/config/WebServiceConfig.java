package com.ust.datasource.config;

import com.ust.datasource.api.DataOperation;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import javax.xml.ws.Endpoint;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@RequiredArgsConstructor
public class WebServiceConfig {

    public static final String ENDPOINT = "/data";

    private final Bus bus;

    @Bean
    public Endpoint endpoint(
        @Qualifier("dataOperationPortImpl") final DataOperation dataOperation) {
        final EndpointImpl endpoint = new EndpointImpl(bus, dataOperation);
        endpoint.publish(ENDPOINT);
        return endpoint;
    }

    @Bean(name = "dataOperationWSClient")
    public JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean() throws MalformedURLException {
        final JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean = new JaxWsPortProxyFactoryBean();
        final URL url = new URL("http://localhost:8080/datasource-ws/data?WSDL");
        jaxWsPortProxyFactoryBean.setWsdlDocumentUrl(url);
        jaxWsPortProxyFactoryBean.setServiceName("HelloService");
        jaxWsPortProxyFactoryBean.setPortName("HelloPort");
        jaxWsPortProxyFactoryBean.setServiceInterface(DataOperation.class);
        jaxWsPortProxyFactoryBean.setNamespaceUri("http://service.ws.sample/");
        jaxWsPortProxyFactoryBean.setLookupServiceOnStartup(false);

        return jaxWsPortProxyFactoryBean;
    }

}
