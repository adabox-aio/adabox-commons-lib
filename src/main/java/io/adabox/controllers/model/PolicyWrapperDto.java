package io.adabox.controllers.model;

import com.bloxbean.cardano.client.transaction.spec.Policy;
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
public class PolicyWrapperDto {

    private String id;
    private Policy policy;
    private Network network;
}
