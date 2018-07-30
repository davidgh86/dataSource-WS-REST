package com.ust.datasource.persistence;

import com.ust.datasource.api.Data;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "data", path = "data")
public interface DataRepository extends PagingAndSortingRepository<Data, String> {

    List<Data> findByNameStartsWithIgnoreCase(@Param("name") String name);

    Data findByDni(@Param("dni") String dni);

}
