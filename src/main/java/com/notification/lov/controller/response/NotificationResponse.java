package com.notification.lov.controller.response;

import com.notification.lov.entity.Notification;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationResponse {

    private Integer id;

    private String message;

    private String title;

    public static NotificationResponse of(Notification notification){
        return NotificationResponse
                .builder()
                .id(notification.getId())
                .message(notification.getMessage())
                .title(notification.getTitle())
                .build();
    }
}
