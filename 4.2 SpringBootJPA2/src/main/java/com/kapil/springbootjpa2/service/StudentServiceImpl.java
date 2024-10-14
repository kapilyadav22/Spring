package com.kapil.springbootjpa2.service;

import com.kapil.springbootjpa2.entity.Student;
import com.kapil.springbootjpa2.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student getStudentByName(String name) {
        return studentRepo.findByName(name);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }

    @Override
    public Student getStudentByPhone(String phone) {
        return studentRepo.findByPhone(phone);
    }

    @Override
    public void setCountryByState(String state, String country) {
            studentRepo.setCountryByState(state, country);
    }
}


/*
Some JPA Queries:
List<User> findByNameAndEmail(String name, String email);
List<User> findByNameOrEmail(String name, String email);
List<User> findByEmailEquals(String email);
List<User> findByPhoneNumberIs(String phoneNumber);
List<User> findByAgeBetween(int startAge, int endAge);
List<User> findByAgeLessThan(int age);
List<User> findByAgeGreaterThan(int age);
List<User> findByNameLike(String namePattern);
List<User> findByEmailNotLike(String emailPattern);
List<User> findByNameIn(List<String> names);
List<User> findByPhoneNumberNotIn(List<String> phoneNumbers);
List<User> findByCreatedDateBefore(LocalDate date);
List<User> findByCreatedDateAfter(LocalDate date);
List<User> findByNameStartsWith(String prefix);
List<User> findByEmailEndsWith(String domain);
List<User> findByPhoneNumberIsNotNull();
List<User> findByEmailIsNull();
List<User> findByOrderByNameAsc();
List<User> findByOrderByEmailDesc();
List<String> findDistinctByName();
long countByName(String name);
List<User> findTop5ByOrderByPhoneNumberAsc();
User findFirstByEmail(String email);

---------------Custom Queries------------------------------------

Find users grouped by email with a count greater than a certain number:
@Query("SELECT u.email, COUNT(u) FROM User u GROUP BY u.email HAVING COUNT(u) > :count")
List<Object[]> countUsersByEmailHavingGreaterThan(@Param("count") long count);



Update the email for a specific user:

@Modifying
@Transactional
@Query("UPDATE User u SET u.email = :email WHERE u.name = :name")
int updateEmailByName(@Param("email") String email, @Param("name") String name);



 */
