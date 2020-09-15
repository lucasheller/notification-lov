package com.notification.lov.service;

import com.notification.lov.repository.NotificationUserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class NotificationUserService {

    private final NotificationUserRepository notificationUserRepository;

    public NotificationUserService(NotificationUserRepository notificationUserRepository) {
        this.notificationUserRepository = notificationUserRepository;
    }

    public Long countUnviewedNotifications(Long userId) {

        return notificationUserRepository.countByViewedAndUserId(false, userId);

    }

    @Transactional
    public void changeNotificationViewedStatus(long userId) {
        notificationUserRepository.updateNotificationToViewed(userId);
    }


}
