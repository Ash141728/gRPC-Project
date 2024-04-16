package com.Insppiron.proto.Service;

import com.BharatKaData.FacebookDataAccessGrpc;
import com.BharatKaData.Notification;
import com.BharatKaData.NotificationList;
import com.BharatKaData.Pagenation;
import com.Insppiron.proto.Model.PayLoadObject;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BharatSarkarService {

    ManagedChannel channel= ManagedChannelBuilder
            .forAddress("localhost",8081)
            .usePlaintext()
            .defaultLoadBalancingPolicy("round_robin")
            .build();

    private FacebookDataAccessGrpc.FacebookDataAccessBlockingStub stub =FacebookDataAccessGrpc.newBlockingStub(channel);



    public List<com.Insppiron.proto.Model.Notification> getAllNotification(int pageSize,int pageNum){

        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Pagenation page = Pagenation.newBuilder().setPageNumber(pageNum).setPageSize(pageSize).build();
        NotificationList allNotification = stub.getAllNotification(page);
        List<Notification> notificationsList = allNotification.getNotificationsList();
       List<com.Insppiron.proto.Model.Notification> notifications=new ArrayList<>();
        for(Notification notification:notificationsList)
        {
            notifications.add(mapToNotification(notification));

        }
        return notifications;

    }
    private com.Insppiron.proto.Model.Notification mapToNotification(Notification notification)
    {
        com.Insppiron.proto.Model.Notification notification1 = new com.Insppiron.proto.Model.Notification();

        notification1.setNotificationId(notification.getNotificationId());

        PayLoadObject payLoadObject=new PayLoadObject();
        payLoadObject.setCity(notification.getPayLoadType().getPersonAddress());
        payLoadObject.setPeopleId(notification.getPayLoadType().getPersonId());
        payLoadObject.setPeopleName(notification.getPayLoadType().getPersonName());

        notification1.setPayLoadObject(payLoadObject);


        return notification1;
    }
}
