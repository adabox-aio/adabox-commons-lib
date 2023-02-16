package io.adabox.captcha;

import io.adabox.captcha.error.ReCaptchaInvalidException;
import io.adabox.captcha.error.ReCaptchaUnavailableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.net.URI;

@Slf4j
@Service("captchaService")
public class CaptchaService extends AbstractCaptchaService {

    @Override
    public void processResponse(final String response) {
        securityCheck(response);
        final URI verifyUri = URI.create(String.format(RECAPTCHA_URL_TEMPLATE, getReCaptchaSecret(), response, getClientIP()));
        try {
            final GoogleResponse googleResponse = restTemplate.getForObject(verifyUri, GoogleResponse.class);
            if (googleResponse == null) {
                throw new ReCaptchaInvalidException("Google Response is null!");
            }
            log.debug("Google's response: {} ", googleResponse);
            if (!googleResponse.isSuccess()) {
                if (googleResponse.hasClientError()) {
                    reCaptchaAttemptService.reCaptchaFailed(getClientIP());
                }
                throw new ReCaptchaInvalidException("reCaptcha was not successfully validated");
            }
        } catch (RestClientException rce) {
            throw new ReCaptchaUnavailableException("Registration unavailable at this time.  Please try again later.", rce);
        }
        reCaptchaAttemptService.reCaptchaSucceeded(getClientIP());
    }
}