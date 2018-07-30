package com.ust.datasource.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "wsclient")
public class WSClientController {

    @Autowired
    @Qualifier("dataOperationWSClient")
    private DataOperation dataOperationWSClient;

    /**
     * http://localhost:8080/wsclient/createData
     *
     * @return
     */
    @GetMapping(path = "/findAll")
    public List<Data> ok() {
        return dataOperationWSClient.findAll();
    }

    /**
     * http://localhost:8080/wsclient/findAll
     *
     * @return
     */
    @GetMapping(path = "/createData")
    public Data ok2() {
        return dataOperationWSClient.createData(Data.builder().name("name").build());
    }

}
