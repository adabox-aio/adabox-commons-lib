package io.adabox.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public enum Network {

    @JsonProperty("undefined")
    UNDEFINED("N/A"),

    @JsonProperty("preview")
    PREVIEW("preview"),

    @JsonProperty("preprod")
    PRE_PROD("preprod"),

    @JsonProperty("mainnet")
    MAIN_NET("mainnet");

    private final String  value;

    Network(String value) {
        this.value = value;
    }

    public static Network fromString(String value) {
        return Arrays.stream(Network.values())
                .filter(network -> network.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(UNDEFINED);
    }

    public String getValue() {
        return value;
    }
}
