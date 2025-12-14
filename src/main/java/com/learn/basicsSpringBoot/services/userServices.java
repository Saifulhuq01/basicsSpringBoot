package com.learn.basicsSpringBoot.services;

import com.learn.basicsSpringBoot.model.user;
import com.learn.basicsSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServices {

    @Autowired
    private UserRepository userRepository;

    public user createuser(user user){
        return  userRepository.save(user);
    }

    public user getuserId(Long id){
        return  userRepository.findById(id).orElseThrow(()-> new RuntimeException("user not found"));
    }


}
