package org.tuxdevelop.spring.cloud.demo.service.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long customerNumber;
    private String firstName;
    private String lastName;
    private String isoCountryCode;
    private String emailAddresss;

}
