// package com.ltim.poc.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.ltim.poc.config.UserInfoUserDetails;
// import com.ltim.poc.entity.User;
// import com.ltim.poc.repository.UserRepository;

// @Service
// public class UserService implements UserDetailsService{

    
//     @Autowired
//     PasswordEncoder encoder;

//     @Autowired
//     private UserRepository userRepository;


//     //register user if username already exist then return null
//     public User registerUser(User user) {
//       Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
//       if (existingUser.isPresent()) {
//         return null; 
//       } else {
//         user.setPassword(encoder.encode(user.getPassword()));
//         return userRepository.save(user);
//       }
//     }

//     // get user by username
//     public User getUserByUsername(String username) {
//       return userRepository.findByUsername(username).get();
//     }

//     public List<User> getAllUser(){
//       return (List<User>) userRepository.findAll();
//     }

    

//     // load UserDetails by username
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Optional<User> user = userRepository.findByUsername(username);
//         return user.map(UserInfoUserDetails::new)
//                     .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
//     }
    
// }
