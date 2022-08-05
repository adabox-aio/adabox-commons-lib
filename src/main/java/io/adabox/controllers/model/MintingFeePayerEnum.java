package io.adabox.controllers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public enum MintingFeePayerEnum {

    @JsonProperty("Buyer")
    BUYER("Buyer"),

    @JsonProperty("Seller")
    SELLER("Seller");

    private final String value;
}
