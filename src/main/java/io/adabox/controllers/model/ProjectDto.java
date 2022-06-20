package io.adabox.controllers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ProjectDto {

    private Long id;
    private String name;
    private String projectUrl;
    private String description;
    private String tokenNamePrefix;
    private Long maxTokenSupply = 1L;
    private Integer reservationTimeMinutes = 30;
    private String payoutWalletAddress;
    private Set<PolicyWrapperDto> policies;
    private String imageUrl;
    private String webhookUrl;

}
