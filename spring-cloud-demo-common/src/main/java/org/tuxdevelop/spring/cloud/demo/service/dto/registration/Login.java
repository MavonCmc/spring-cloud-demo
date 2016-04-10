package org.tuxdevelop.spring.cloud.demo.service.dto.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tuxdevelop.spring.cloud.demo.service.dto.common.CommonPojo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login extends CommonPojo {

    private String userName;
    private String password;
}
