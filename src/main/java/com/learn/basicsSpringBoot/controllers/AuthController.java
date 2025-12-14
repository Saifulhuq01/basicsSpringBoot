package com.learn.basicsSpringBoot.controllers;

import com.learn.basicsSpringBoot.model.user;
import com.learn.basicsSpringBoot.repository.UserRepository;
import com.learn.basicsSpringBoot.services.userServices;
import com.learn.basicsSpringBoot.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final userServices userServicess;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

//    http://localhost:8080/auth/register
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = body.get("password");
        password = passwordEncoder.encode(password);
        if (userRepository.findByEmail(email).isPresent()){
            return new ResponseEntity<>("Email already exists", HttpStatus.CONFLICT);
        }
        userServicess.createuser(user.builder().email(email).password(password).build());
        return new ResponseEntity<>("Successfully Registered", HttpStatus.CREATED);
    }

//    http://localhost:8080/auth/login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String,String> body){
        String email = body.get("email");
        String password = body.get("password");

        var userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()){
            return new ResponseEntity<>("User not Registered", HttpStatus.UNAUTHORIZED);
        }
        user user = userOptional.get();
        if (!passwordEncoder.matches(password, user.getPassword())){
            return new ResponseEntity<>("Invalid user", HttpStatus.UNAUTHORIZED);
        }
        String token = jwtUtil.generateToken(email);
        return ResponseEntity.ok(Map.of("token", token));

    }
}
