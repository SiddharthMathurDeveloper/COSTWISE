package com.costwiseai.costwise.controllers;


import com.costwiseai.costwise.services.NotificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    NotificationService notificationService;
    


    @GetMapping("/send-notification")
    public String sendNotification() {
        System.out.println(notificationService.allUser());
        return "232";
    }

    @PostMapping("/client-activate/{UserId}")
    public ResponseEntity<String> clientActivate(@PathVariable("UserId") int userId) {
        notificationService.setUserActive(userId);
        return ResponseEntity.ok("User with ID " + userId + " activated successfully");
    }



    @PostMapping("/client-deactivate/{UserId}")
    public ResponseEntity<String> clientDeactivate(@PathVariable("UserId") int userId) {
        notificationService.setUserDeactivate(userId);
        return ResponseEntity.ok("User with ID " + userId + " deactivated successfully");
    }


   

    
}
