package com.notification.lov.repository;

import com.notification.lov.entity.NotificationUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NotificationUserRepository extends CrudRepository<NotificationUser, Integer> {

    Long countByViewedAndUserId(boolean viewed, Long userId);

    @Modifying
    @Query(value = "UPDATE NotificationUser nu SET nu.viewed = true WHERE nu.userId = ?1")
    void updateNotificationToViewed(@Param("USER_ID") Long userId);


}
