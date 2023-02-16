package io.adabox.captcha.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "ReCaptcha is Invalid")
public final class ReCaptchaInvalidException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5861310537366287163L;

    public ReCaptchaInvalidException() {
        super();
    }

    public ReCaptchaInvalidException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ReCaptchaInvalidException(final String message) {
        super(message);
    }

    public ReCaptchaInvalidException(final Throwable cause) {
        super(cause);
    }
}