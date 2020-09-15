package com.notification.lov.controller.request;

import com.notification.lov.entity.NotificationUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class NotificationRequest {

    @Size(max = 60)
    @ApiModelProperty(value = "Message of notification")
    private String message;

    @Size(max = 60)
    @ApiModelProperty(value = "Title of notification")
    private String title;

    @Valid
    private List<Long> usersId;
}
