package org.tuxdevelop.spring.cloud.demo.service.dto.customer;

import lombok.*;
import org.tuxdevelop.spring.cloud.demo.service.dto.common.CommonPojo;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends CommonPojo {

    private String firstName;
    private String lastName;
    private String isoCountryCode;
    private String emailAddress;

}
