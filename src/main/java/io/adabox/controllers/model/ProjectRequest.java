package io.adabox.controllers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.adabox.config.Network;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProjectRequest {

    private String name;
    private String projectUrl;
    private String description;
    private String tokenNamePrefix;
    private Long maxTokenSupply = 1L;
    private Integer reservationTimeMinutes = 30;
    private Long time;
    private boolean timeLocked;
    private String webhookUrl;
    private Network network;
    private PricingDto pricing;

}
