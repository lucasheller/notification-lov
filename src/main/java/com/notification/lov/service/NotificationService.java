package com.notification.lov.service;

import com.notification.lov.controller.request.NotificationRequest;
import com.notification.lov.entity.Notification;
import com.notification.lov.entity.NotificationUser;
import com.notification.lov.repository.NotificationRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public Notification create(NotificationRequest notificationRequest) {
        final List<NotificationUser> notificationUsers = notificationRequest.getUsersId().stream()
                .map(userId -> NotificationUser.builder().userId(userId).build())
                .collect(Collectors.toList());
        final Notification notification = Notification.builder()
                .message(notificationRequest.getMessage())
                .title(notificationRequest.getTitle())
                .notificationUsers(notificationUsers)
                .build();

        notificationRepository.save(notification);

        return notification;
    }

    public List<Notification> listNotification(long userId,int page, int size){
        final Pageable pageable = PageRequest.of(page,size);
        return notificationRepository.listNotificationForUser(userId,pageable);
    }


}
