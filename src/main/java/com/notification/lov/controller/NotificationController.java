package com.notification.lov.controller;

import com.notification.lov.controller.request.NotificationRequest;
import com.notification.lov.controller.response.NotificationResponse;
import com.notification.lov.entity.Notification;
import com.notification.lov.service.NotificationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Create notification")
    public ResponseEntity<Void> create(@Valid @RequestBody NotificationRequest notificationRequest) {

        final Notification notification = notificationService.create(notificationRequest);

        final URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(notification.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Count unviewed notifications for one user")
    public ResponseEntity<List<NotificationResponse>> listNotification(@RequestParam long userId,
                                                                       @RequestParam(value = "page", defaultValue = "0") int page,
                                                                       @RequestParam(value = "size", defaultValue = "20") int size) {
        return ResponseEntity.ok(notificationService.listNotification(userId,page,size).stream().map(NotificationResponse::of).collect(Collectors.toList()));
    }


}
