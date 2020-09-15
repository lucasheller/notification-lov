package com.notification.lov.controller;

import com.notification.lov.service.NotificationUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification-user")
public class NotificationUserController {

    private final NotificationUserService notificationUserService;

    public NotificationUserController(NotificationUserService notificationUserService) {
        this.notificationUserService = notificationUserService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Count unviewed notifications for one user")
    public ResponseEntity<Long> countUnviewedNotifications(@RequestParam long userId) {
        return ResponseEntity.ok(notificationUserService.countUnviewedNotifications(userId));
    }

    @PutMapping
    @ApiOperation("Change the status of unviewed notification to viewed")
    public ResponseEntity changeViewedNotificationStatus(@RequestParam long userId) {

        notificationUserService.changeNotificationViewedStatus(userId);
        return ResponseEntity.ok().build();
    }


}
