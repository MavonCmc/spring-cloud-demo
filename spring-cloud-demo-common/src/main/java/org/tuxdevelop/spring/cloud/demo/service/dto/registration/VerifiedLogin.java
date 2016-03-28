package org.tuxdevelop.spring.cloud.demo.service.dto.registration;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VerifiedLogin {

    private String userName;
    private Long customerId;

}
