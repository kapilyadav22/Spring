package com.kapil.springdatajpa.Repo;

import org.springframework.data.repository.CrudRepository;
import com.kapil.springdatajpa.Users;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Users, Integer> {

}