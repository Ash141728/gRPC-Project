package com.Insppiron.proto.Service;

import com.BharatKaData.*;
import com.Insppiron.proto.Dto.NotificationDto;
import com.Insppiron.proto.Model.Notification;
import com.Insppiron.proto.Repository.NotificationRepository;
import io.grpc.stub.StreamObserver;

import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@GrpcService

public class NotificationServiceImpl extends FacebookDataAccessGrpc.FacebookDataAccessImplBase implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    public void save(NotificationDto notificationDto) {

        Notification save = notificationRepository.save(processData(notificationDto));
    }

    public Notification getById() {
        return null;
    }

    public void update() {

    }

    public void delete() {

    }

    public Notification processData(NotificationDto notificationDto) {
        Notification notification = new Notification();
        notification.setNotificationId(notificationDto.getNotificationId());
        notification.setPayLoadObject(notificationDto.getPayLoadObject());
        notification.setCreatedOn(notificationDto.getCreatedOn());
        return notification;
    }

    @Override
    public void getAllNotification(Pagenation pagenation, StreamObserver<com.BharatKaData.NotificationList> responseObserver) {

        int pageSize = pagenation.getPageSize();
        int pageNumber = pagenation.getPageNumber();
        Pageable pageable = PageRequest.of(pageNumber-1,pageSize);
        List<Notification> all = notificationRepository.findAll(pageable).getContent();



        NotificationList.Builder notificationListBuilder = NotificationList.newBuilder();


        // Iterate over each Notification object in the repository data
        for (Notification notification : all) {
            // Create a protobuf Notification object
            com.BharatKaData.Notification.Builder notificationBuilder = com.BharatKaData.Notification.newBuilder();
            notificationBuilder.setNotificationId(notification.getNotificationId());

            // Create a protobuf PayLoadType object
            PayLoadType.Builder payLoadTypeBuilder = PayLoadType.newBuilder();
            payLoadTypeBuilder.setPersonId(notification.getPayLoadObject().getPeopleId());
            payLoadTypeBuilder.setPersonName(notification.getPayLoadObject().getPeopleName());
            payLoadTypeBuilder.setPersonAddress(notification.getPayLoadObject().getCity());

            // Set the PayLoadType object in Notification
            notificationBuilder.setPayLoadType(payLoadTypeBuilder.build());

            // Add the Notification to NotificationList
            notificationListBuilder.addNotifications(notificationBuilder.build());
        }

        // Build the NotificationList
        NotificationList notificationListProto = notificationListBuilder.build();
        responseObserver.onNext(notificationListProto);
        responseObserver.onCompleted();


    }
}

