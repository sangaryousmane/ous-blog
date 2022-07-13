//package com.example.facebook.security;
//
//import com.example.facebook.entities.User;
//import com.example.facebook.repo.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class FacebookUserDetailsService implements UserDetailsService {
//
//    public UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmail(email);
//        if (user == null) {
//            throw new UsernameNotFoundException("User Not Found.");
//        }
//        return new FacebookUserDetails(user);
//    }
//}
