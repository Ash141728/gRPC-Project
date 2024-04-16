package com.Insppiron.proto.Controller;


import com.Insppiron.proto.Dto.NotificationDto;
import com.Insppiron.proto.Model.Notification;
import com.Insppiron.proto.Service.NotificationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    NotificationServiceImpl notificationService;

    @PostMapping("/save")
    public void save(@RequestBody NotificationDto notificationDto){
        System.out.println(notificationDto);
        notificationService.save(notificationDto);

    }
    @GetMapping("/{id}")
    public void getById(@PathVariable int id){

    }
    @DeleteMapping
    public void delete(){

    }
    @PutMapping
    public void update(){

    }
   public List<Notification> getAllNotification(){
        return null;
    }
}
