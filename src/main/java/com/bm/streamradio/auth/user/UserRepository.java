package com.bm.streamradio.auth.user;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    User findFirstById(UUID id);
    User findByUsername(String username);
    ArrayList<User> findAll();
}
