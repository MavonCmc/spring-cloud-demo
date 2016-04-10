package org.tuxdevelop.spring.cloud.demo.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationModel {

    private Registration registration;
    private CustomerDTO customerDTO;

}
