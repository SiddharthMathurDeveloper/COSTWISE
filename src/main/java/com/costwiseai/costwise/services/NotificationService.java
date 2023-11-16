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

    public Optional<User> setUserActive(int id){
        Optional<User> optionalEntity =  userRepository.findById(id);
        User entity = optionalEntity.get();
        LocalDateTime currentDateTime = LocalDateTime.now();
        Date currentDate = Date.from(currentDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant());
        if (optionalEntity.isPresent()) {

        } else {

            entity.setLoggedIn(true); // Set the new field value
            entity.setCreatedAt(currentDate);
            return Optional.ofNullable(userRepository.save(entity)); // Save the updated entity
        }



        return optionalEntity;
    }
}
