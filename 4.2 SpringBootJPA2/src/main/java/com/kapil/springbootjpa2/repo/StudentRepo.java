package com.kapil.springbootjpa2.repo;

import com.kapil.springbootjpa2.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findByName(String name);
    Student findByEmail(String email);
    Student findByPhone(String phone);


    @Modifying
    @Transactional
    @Query("Update Student s set s.country = :country where s.state= :state")
    void setCountryByState(@Param("state") String state, @Param("country") String country);

}
