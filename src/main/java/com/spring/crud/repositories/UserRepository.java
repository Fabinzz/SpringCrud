package com.spring.crud.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
