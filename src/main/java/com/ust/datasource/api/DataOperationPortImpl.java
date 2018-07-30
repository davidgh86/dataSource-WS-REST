package com.ust.datasource.api;

import com.ust.datasource.persistence.DataRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "HelloService", portName = "HelloPort",
    targetNamespace = "http://service.ws.sample/",
    endpointInterface = "com.ust.datasource.api.DataOperation")
@Service
@Slf4j
public class DataOperationPortImpl implements DataOperation {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public Data createData(final Data data) {
        log.info("data:{}", data);
        return dataRepository.save(data);
    }

    @Override
    public Data readData(final String id) {
        return dataRepository.findOne(id);
    }

    @Override
    public List<Data> findByName(final String name) {
        return dataRepository.findByNameStartsWithIgnoreCase(name);
    }

    @Override
    public Data findByDni(final String dni) {
        return dataRepository.findByDni(dni);
    }

    @Override
    public Data update(final Data data) {
        return dataRepository.save(data);
    }

    @Override
    public void delete(final String id) {
        dataRepository.delete(id);
    }

    @Override
    public List<Data> findAll() {
        return IteratorUtils.toList(dataRepository.findAll().iterator());
    }

}
