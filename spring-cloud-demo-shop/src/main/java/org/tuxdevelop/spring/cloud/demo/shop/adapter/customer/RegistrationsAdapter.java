package org.tuxdevelop.spring.cloud.demo.shop.adapter.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Login;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.VerifiedLogin;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.AbstractAdapter;

@Component
public class RegistrationsAdapter extends AbstractAdapter {

    //TODO: externalize properties
    private static final String BASE_URL = "http://localhost:9000/customer-service/registrations";

    private final RestTemplate restTemplate;

    @Autowired
    public RegistrationsAdapter(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Registration createRegistration(final Long customerNumber, final String userName, final String password) {
        final Registration registration = new Registration();
        registration.setCustomerNumber(customerNumber);
        registration.setLogin(new Login(userName, password));
        final HttpEntity<Registration> httpEntity = new HttpEntity<>(registration, prepareHeaders());
        final ResponseEntity<Registration> response = restTemplate.exchange(BASE_URL, HttpMethod.POST, httpEntity, Registration.class);
        return response.getBody();
    }

    public void performLogin(final String userName, final String password) {
        final UriComponentsBuilder verifyBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/logins/verify")
                .queryParam("username", userName)
                .queryParam("password", password);
        final ResponseEntity<Boolean> isVerifiedResponse = restTemplate.getForEntity(verifyBuilder.toUriString(), Boolean.class);
        if (!isVerifiedResponse.getBody()) {
            throw new BadCredentialsException("Login Failed, Bad Credentials!");
        }
    }

    public VerifiedLogin getVerfiedLogin(final String userName) {
        final UriComponentsBuilder verifyBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/logins")
                .queryParam("username", userName);
        final ResponseEntity<VerifiedLogin> response = restTemplate.getForEntity(verifyBuilder.toUriString(),
                VerifiedLogin.class);
        return response.getBody();
    }

    public Boolean verifyUserName(final String userName) {
        final UriComponentsBuilder verifyBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL +
                "/logins/username/exists")
                .queryParam("username", userName);
        final ResponseEntity<Boolean> response = restTemplate.getForEntity(verifyBuilder.toUriString(), Boolean.class);
        return response.getBody();
    }

}
