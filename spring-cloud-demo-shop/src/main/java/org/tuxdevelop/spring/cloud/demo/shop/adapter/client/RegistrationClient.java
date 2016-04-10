package org.tuxdevelop.spring.cloud.demo.shop.adapter.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.VerifiedLogin;

@FeignClient(url = "http://localhost:9000/customer-service")
public interface RegistrationClient {

    @RequestMapping(value = "/registrations", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Registration saveRegistration(Registration registration);

    @RequestMapping(value = "/registrations/logins/verify", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean verifyLogin(@RequestParam("username") String userName, @RequestParam("password") String password);

    @RequestMapping(value = "/registrations/logins", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    VerifiedLogin getVerfiedLogin(@RequestParam("username") final String userName);

    @RequestMapping(value = "/registrations//logins/username/exists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean verifyUserName(@RequestParam("username") final String userName);

}
