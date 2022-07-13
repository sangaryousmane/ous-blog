package com.example.jpa.relationship1.repos;

import com.example.jpa.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByNameContaining(String name);

    List<Student> findDistinctByEmailAndSchool(String email, String school);

    @Query("SELECT s FROM Student s WHERE s.name LIKE %?1")
    List<Student> findByNameEndingWith(@Param("name") String name);

    @Query("SELECT s FROM Student s WHERE s.id =?1")
    Student getById(Long id);


    Page<Student> findStudentByName(String name, Pageable pageable);

    @Query("SELECT s FROM Student s WHERE s.name=:name AND s.email=:email")
    Student findStudentByNameAndEmail(@Param("name") String name,
                                      @Param("email") String email);

    @Query("SELECT s FROM #{#entityName} s WHERE s.school=:school")
    Student findStudentBySchool(@Param("school") String school);

    void deleteStudentById(Long id);

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Student s WHERE s.id=:id")
    int deleteByStudentId(@Param("id") Long id);

    @Modifying
    @Query("UPDATE Student s SET s.name=:name WHERE s.email=:email")
    Integer updateStudent(@Param("name") String name,
                          @Param("email") String email);

    List<Student> findByGuardianName(String name);

    // TODO: This is neither native SQL nor HQL but JPQL
    @Query("SELECT s FROM Student s WHERE s.email=?1")
    Student getStudentByEmail(String email);

    // TODO: This is a native query in JPA repository
    @Query(value = "select *from students s where s.email=?1", nativeQuery = true)
    Student getStudentByEmailNative(String email);

    @Query(value = "select * from students s where s.email=:email", nativeQuery = true)
    Student getStudentByEmailNativeParam(@Param("email") String email);
}