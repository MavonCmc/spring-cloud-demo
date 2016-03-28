package org.tuxdevelop.spring.cloud.demo.service.dto.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.tuxdevelop.spring.cloud.demo.service.dto.common.CommonPojo;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
public class Registration extends CommonPojo {

    public Registration() {
        this.login = new Login();
    }

    private Login login;
    private Long customerNumber;

}
