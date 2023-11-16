package com.costwiseai.costwise.controllers;


import com.costwiseai.costwise.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/client-Activate")
    public String clientActivate() {

        return "232";
    }



    @PostMapping("/client-deactivate")
    public String clientDeactivate() {

        return "232";
    }
}
