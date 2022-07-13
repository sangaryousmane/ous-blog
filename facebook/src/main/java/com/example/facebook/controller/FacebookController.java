//package com.example.facebook.controller;
//
//import com.example.facebook.entities.User;
//import com.example.facebook.utils.FacebookService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/facebook")
//@RequiredArgsConstructor
//public class FacebookController {
//
//    private final FacebookService facebookService;
//
//
//    @GetMapping("/registration")
//    public String main(){
//        return facebookService.main();
//    }
//
//    @PostMapping("/join")
//    public String register(@RequestBody User user){
//       return facebookService.register(user);
//    }
//
//    @GetMapping("/users")
//    public ResponseEntity<List<User>> usersList(){
//        return ResponseEntity.ok(facebookService.userList());
//    }
//
//}
