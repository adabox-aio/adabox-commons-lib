package io.adabox.controllers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class NotificationDto {

    private Long id;
    private NotificationType notificationType;
    private ProjectMemberDto receiver;
    private ProjectMemberDto sender;
    private String msg;
    private boolean ack;
    private Date timeCreated;
    private Date timeAck;
    private boolean acceptLoading;
    private boolean declineLoading;
    private String result;
}
