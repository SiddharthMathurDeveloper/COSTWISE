package com.costwiseai.costwise.services;

import com.costwiseai.costwise.models.User;
import com.costwiseai.costwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class NotificationService {

    @Autowired
    UserRepository userRepository;

    public List<User> allUser() {
        List<User> users = userRepository.findAll();
        return  users;
    }

    public Boolean setUserActive(int id){
        Optional<User> optionalEntity =  userRepository.findById(id);
        User entity = optionalEntity.get();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Date currentDate = Date.from(currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant());
            entity.setLoggedIn(true); // Set the new field value
            entity.setUpdatedAt(currentDate);
            userRepository.save(entity);
        return true;
    }

     public Boolean setUserDeactivate(int id){
        Optional<User> optionalEntity =  userRepository.findById(id);
        User entity = optionalEntity.get();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Date currentDate = Date.from(currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant());
            entity.setLoggedIn(false); // Set the new field value
            entity.setUpdatedAt(currentDate);
            userRepository.save(entity);
        return true;
    }
}
