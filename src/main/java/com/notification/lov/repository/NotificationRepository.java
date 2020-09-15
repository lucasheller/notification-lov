package com.notification.lov.repository;

import com.notification.lov.entity.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NotificationRepository extends CrudRepository<Notification, Integer> {

    @Query(value = "select * from notification n inner join notification_user nu  on n.notification_id = nu.notification_id where nu.user_id = ?1",nativeQuery = true)
    List<Notification> listNotificationForUser(long userId, Pageable pageable);
}
