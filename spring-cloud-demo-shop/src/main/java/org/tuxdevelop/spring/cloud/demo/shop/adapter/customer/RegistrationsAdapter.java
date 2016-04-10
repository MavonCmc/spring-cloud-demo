package org.tuxdevelop.spring.cloud.demo.shop.adapter.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Login;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.VerifiedLogin;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.client.RegistrationClient;

@Component
public class RegistrationsAdapter {

    private final RegistrationClient registrationClient;

    @Autowired
    public RegistrationsAdapter(final RegistrationClient registrationClient) {
        this.registrationClient = registrationClient;
    }

    public Registration createRegistration(final Long customerNumber, final String userName, final String password) {
        final Registration registration = new Registration();
        registration.setCustomerNumber(customerNumber);
        registration.setLogin(new Login(userName, password));
        return registrationClient.saveRegistration(registration);
    }

    public void performLogin(final String userName, final String password) {
        final Boolean response = registrationClient.verifyLogin(userName, password);
        if (!response) {
            throw new BadCredentialsException("Login Failed, Bad Credentials!");
        }
    }

    public VerifiedLogin getVerfiedLogin(final String userName) {
        return registrationClient.getVerfiedLogin(userName);
    }

    public Boolean verifyUserName(final String userName) {
        return registrationClient.verifyUserName(userName);
    }

}
