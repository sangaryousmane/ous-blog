package com.example.facebook.controller;

import com.example.facebook.entities.Role;
import com.example.facebook.entities.User;
import com.example.facebook.repo.RoleRepository;
import com.example.facebook.repo.UserRepository;
import com.example.jpa.Student;
import com.example.jpa.relationship1.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> students() {
        List<Student> endingWith = studentRepository.findByNameEndingWith("on");
        return ResponseEntity.ok(endingWith);
    }

    @PostMapping("/addRoles/{name}")
    public void addRoleToAllUsers(@PathVariable(required = false, name = "name") String name) {
        Role role = roleRepository.findRoleByName(name);
        List<User> users = userRepository.findAll();

        for (User user : users) {
            user.addRole(role);
            userRepository.save(user);
        }
    }
}
