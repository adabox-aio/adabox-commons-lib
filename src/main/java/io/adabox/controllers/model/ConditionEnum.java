package io.adabox.controllers.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public enum ConditionEnum {

    /**
     * Delegating to Specific Stake Pools
     */
    @JsonProperty("Delegating to Specific Stake Pools")
    DELEGATING_TO_SPECIFIC_STAKE_POOLS("Delegating to Specific Stake Pools"),

    @JsonProperty("Owning Tokens from Specific Policies")
    OWNING_TOKENS_FROM_SPECIFIC_POLICIES("Owning Tokens from Specific Policies"),

    /**
     * Whitelist
     */
    @JsonProperty("Whitelist")
    WHITELIST("Whitelist"),

    /**
     * Blacklist
     */
    @JsonProperty("Blacklist")
    BLACKLIST("Blacklist");

    private final String value;

}
