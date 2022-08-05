package io.adabox.controllers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public enum PricingPlanEnum {

    @JsonProperty("Fixed Price")
    FIXED_PRICE("Fixed Price"),

    @JsonProperty("Bundled Price")
    BUNDLED_PRICE("Bundled Price");

    private final String value;

    PricingPlanEnum(String value) {
        this.value = value;
    }
}
