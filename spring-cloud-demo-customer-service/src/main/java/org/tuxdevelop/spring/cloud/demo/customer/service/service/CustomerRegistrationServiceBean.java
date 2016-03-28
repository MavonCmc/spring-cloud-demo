package org.tuxdevelop.spring.cloud.demo.customer.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.RegistrationRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Login;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.VerifiedLogin;

@RestController
@RequestMapping(value = "/registrations")
public class CustomerRegistrationServiceBean {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public CustomerRegistrationServiceBean(final RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Registration add(@RequestBody final Registration registration) {
        validateLogin(registration.getLogin());
        validateCustomerNumber(registration.getCustomerNumber());
        if (registrationRepository.containsUserName(registration.getLogin().getUserName())) {
            throw new IllegalArgumentException("Username already exists");
        }
        return registrationRepository.save(registration);
    }

    @RequestMapping(value = "logins", method = RequestMethod.GET, produces = "application/json")
    public VerifiedLogin getVerifiedLogin(@RequestParam(name = "username") final String userName) {
        final Registration registration = registrationRepository.findRegistrationByUserName(userName);
        if (registration == null) {
            throw new IllegalArgumentException("Unknown username :" + userName);
        }
        return new VerifiedLogin(userName, registration.getCustomerNumber());
    }

    @RequestMapping(value = "logins/verify", method = RequestMethod.GET, produces = "application/json")
    public Boolean verifyLogin(@RequestParam(name = "username") final String userName,
                               @RequestParam(name = "password") final String password) {
        final Login login = registrationRepository.findLoginByUserName(userName);
        final Boolean result;
        if (login != null) {
            result = login.getPassword().equals(password);
        } else {
            result = Boolean.FALSE;
        }
        return result;
    }

    @RequestMapping(value = "logins/username/exists", method = RequestMethod.GET, produces = "application/json")
    public Boolean userNameExists(@RequestParam(name = "username") final String userName) {
        return registrationRepository.findLoginByUserName(userName) != null;
    }


    void validateLogin(final Login login) {
        if (login == null) {
            throw new IllegalArgumentException("login must not be null");
        }
        if (login.getUserName() == null || login.getUserName().isEmpty()) {
            throw new IllegalArgumentException("User name must not be null or empty");
        }
        if (login.getPassword() == null || login.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password must not be null or empty");
        }
    }

    void validateCustomerNumber(final Long customerNumber) {
        if (customerNumber == null) {
            throw new IllegalArgumentException("Customer Number must not be null");
        }
    }

}
