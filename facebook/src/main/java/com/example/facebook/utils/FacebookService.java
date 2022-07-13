//package com.example.facebook.utils;
//
//import com.example.facebook.entities.Role;
//import com.example.facebook.entities.User;
//import com.example.facebook.repo.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class FacebookService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private static final String DEFAULT_USER_ROLE= "USER";
//
//
//    public String main() {
//        return "<b>Welcome to the registration page...</b>";
//    }
//
//    public String register(User user){
//        user.addRole(new Role(DEFAULT_USER_ROLE));
//        String encodedPassword=passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        userRepository.save(user);
//        return "register successful!!!";
//    }
//
//    public List<User> userList(){
//        return userRepository.findAll();
//    }
//
//
//}
