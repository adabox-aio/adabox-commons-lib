package io.adabox.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Network {

    @JsonProperty("testnet")
    TEST_NET("testnet"),

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
        for (Network network : Network.values()) {
            if (network.getValue().equalsIgnoreCase(value)) {
                return network;
            }
        }
        return TEST_NET;
    }

    public String getValue() {
        return value;
    }
}
