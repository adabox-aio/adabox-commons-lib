package io.adabox.captcha;

import io.adabox.captcha.error.ReCaptchaInvalidException;

public interface ICaptchaService {

    default void processResponse(final String response) throws ReCaptchaInvalidException {}

    default void processResponse(final String response, String action) throws ReCaptchaInvalidException {}

    /**
     * get Re-Captcha Site
     * @return recaptcha site
     */
    String getReCaptchaSite();

    String getReCaptchaSecret();
}
