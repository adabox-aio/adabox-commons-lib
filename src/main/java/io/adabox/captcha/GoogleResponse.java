package io.adabox.captcha;

import com.fasterxml.jackson.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "success", "score", "action","challenge_ts", "hostname", "error-codes" })
public class GoogleResponse {

    @JsonProperty("success")
    private boolean success;
    @JsonProperty("challenge_ts")
    private String challengeTs;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("score")
    private float score;
    @JsonProperty("action")
    private String action;
    @JsonProperty("error-codes")
    private ErrorCode[] errorCodes;

    enum ErrorCode {
        INCORRECT_CAPTCHA_SOL, INVALID_KEYS, MISSING_SECRET, INVALID_SECRET, MISSING_RESPONSE, INVALID_RESPONSE, BAD_REQUEST, TIMEOUT_OR_DUPLICATE, BROWSER_ERROR;

        private static final Map<String, ErrorCode> errorsMap = new HashMap<>(6);

        static {
            errorsMap.put("incorrect-captcha-sol", INCORRECT_CAPTCHA_SOL);
            errorsMap.put("invalid-keys", INVALID_KEYS);
            errorsMap.put("missing-input-secret", MISSING_SECRET);
            errorsMap.put("invalid-input-secret", INVALID_SECRET);
            errorsMap.put("missing-input-response", MISSING_RESPONSE);
            errorsMap.put("bad-request", INVALID_RESPONSE);
            errorsMap.put("invalid-input-response", BAD_REQUEST);
            errorsMap.put("timeout-or-duplicate", TIMEOUT_OR_DUPLICATE);
            errorsMap.put("browser-error", BROWSER_ERROR);
        }

        @JsonCreator
        public static ErrorCode forValue(final String value) {
            return errorsMap.get(value.toLowerCase());
        }
    }

    @JsonProperty("success")
    public boolean isSuccess() {
        return success;
    }

    @JsonProperty("success")
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @JsonProperty("challenge_ts")
    public String getChallengeTs() {
        return challengeTs;
    }

    @JsonProperty("challenge_ts")
    public void setChallengeTs(String challengeTs) {
        this.challengeTs = challengeTs;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    @JsonProperty("error-codes")
    public void setErrorCodes(ErrorCode[] errorCodes) {
        this.errorCodes = errorCodes;
    }

    @JsonProperty("error-codes")
    public ErrorCode[] getErrorCodes() {
        return errorCodes;
    }

    @JsonProperty("score")
    public float getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(float score) {
        this.score = score;
    }

    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    @JsonIgnore
    public boolean hasClientError() {
        final ErrorCode[] errors = getErrorCodes();
        if (errors == null) {
            return false;
        }
        for (final ErrorCode error : errors) {
            switch (error) {
                case INCORRECT_CAPTCHA_SOL -> {
                    log.warn("Incorrect Captcha");
                    return true;
                }
                case INVALID_KEYS -> {
                    log.warn("Invalid Keys");
                    return true;
                }
                case INVALID_RESPONSE -> {
                    log.warn("Invalid Response");
                    return true;
                }
                case MISSING_RESPONSE -> {
                    log.warn("Missing Response");
                    return true;
                }
                case BAD_REQUEST -> {
                    log.warn("Bad Request");
                    return true;
                }
                case BROWSER_ERROR -> {
                    log.warn("Browser Error");
                    return true;
                }
                default -> {
                    // empty
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "GoogleResponse{" + "success=" + success + ", challengeTs='" + challengeTs + '\'' + ", hostname='" + hostname + '\''+ ", score='" + score + '\''+ ", action='" + action+ '\'' + ", errorCodes=" + Arrays.toString(errorCodes) + '}';
    }
}
