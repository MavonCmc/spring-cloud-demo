package org.tuxdevelop.spring.cloud.demo.customer.service.repository;


import org.springframework.stereotype.Repository;
import org.tuxdevelop.spring.cloud.demo.repository.MapRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Login;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;

import java.util.List;

@Repository
public class RegistrationRepository extends MapRepository<Registration> {

    public Registration findRegistrationByUserName(final String userName) {
        final List<Registration> registrations = findAll();
        Registration registration = null;
        for (final Registration reg : registrations) {
            if (reg.getLogin().getUserName().equals(userName)) {
                registration = reg;
                break;
            }
        }
        return registration;
    }

    public Boolean containsUserName(final String userName) {
        final Login login = findLoginByUserName(userName);
        return login != null;
    }

    public Login findLoginByUserName(final String userName) {
        final List<Registration> registrations = findAll();
        Login login = null;
        for (final Registration registration : registrations) {
            if (registration.getLogin().getUserName().equals(userName)) {
                login = registration.getLogin();
                break;
            }
        }
        return login;
    }

}
