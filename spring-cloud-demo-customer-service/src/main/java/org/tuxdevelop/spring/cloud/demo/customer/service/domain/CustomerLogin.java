package org.tuxdevelop.spring.cloud.demo.customer.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Login;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_login")
public class CustomerLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_login_id")
    private Long customerLoginId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    public CustomerLogin(final Login login) {
        this.userName = login.getUserName();
        this.password = login.getPassword();
        this.customerLoginId = login.getId();
    }

    public Login mapToDTO() {
        final Login login = new Login();
        login.setPassword(password);
        login.setUserName(userName);
        login.setId(customerLoginId);
        return login;
    }

}
