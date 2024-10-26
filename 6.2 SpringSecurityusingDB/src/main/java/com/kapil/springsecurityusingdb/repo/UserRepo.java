package com.kapil.springsecurityusingdb.repo;

import com.kapil.springsecurityusingdb.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, String> {
   Optional<Users> findByEmail(String email);

}
