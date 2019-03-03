package com.bm.streamradio.repository;

import com.bm.streamradio.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "account", path = "account")
public interface AccountRepository extends PagingAndSortingRepository<Account, UUID> {

    /*
     * GET http://localhost:8080/people
     * POST http://localhost:8080/people {"firstName": "Frodo", "lastName": "Baggins2"}
     * List<Person> findByLastName(@Param("name") String name);
     * */
}
