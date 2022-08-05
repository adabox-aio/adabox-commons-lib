package io.adabox.captcha;

import io.adabox.captcha.error.ReCaptchaInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestOperations;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * AbstractCaptchaService
 */
@Slf4j
public abstract class AbstractCaptchaService implements ICaptchaService {

    /**
     * Http Servlet Request
     */
    @Autowired
    protected HttpServletRequest request;

    /**
     * Captcha Settings
     */
    @Autowired
    protected CaptchaSettings captchaSettings;

    /**
     * Re Captcha Attempt Service
     */
    @Autowired
    protected ReCaptchaAttemptService reCaptchaAttemptService;

    /**
     * Rest Operations
     */
    @Autowired
    protected RestOperations restTemplate;

    protected static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z\\d_-]+");

    protected static final String RECAPTCHA_URL_TEMPLATE = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";

    @Override
    public String getReCaptchaSite() {
        return captchaSettings.getSite();
    }

    @Override
    public String getReCaptchaSecret() {
        return captchaSettings.getSecret();
    }


    protected void securityCheck(final String response) {
        log.debug("Attempting to validate response {}", response);
        if (reCaptchaAttemptService.isBlocked(getClientIP())) {
            throw new ReCaptchaInvalidException("Client exceeded maximum number of failed attempts");
        }
        if (!responseSanityCheck(response)) {
            throw new ReCaptchaInvalidException("Response contains invalid characters");
        }
    }

    protected boolean responseSanityCheck(final String response) {
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    protected String getClientIP() {
        final String xfHeader = request.getHeader("X-Forwarded-For");
        if (xfHeader == null) {
            return request.getRemoteAddr();
        }
        return xfHeader.split(",")[0];
    }
}
