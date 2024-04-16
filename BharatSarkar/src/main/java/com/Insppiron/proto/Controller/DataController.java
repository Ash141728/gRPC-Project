package com.Insppiron.proto.Controller;

import com.Insppiron.proto.Model.Notification;
import com.Insppiron.proto.Service.BharatSarkarService;
import com.google.protobuf.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    BharatSarkarService bharatSarkarService;

    @GetMapping("/get")
    public List<Notification> getAllNotification(@RequestParam int pageSize, @RequestParam int pageNum){


        return bharatSarkarService.getAllNotification(pageSize,pageNum);


    }


}
