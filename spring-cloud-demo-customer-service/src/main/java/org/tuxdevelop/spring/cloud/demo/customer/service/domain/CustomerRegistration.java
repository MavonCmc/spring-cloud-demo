package org.tuxdevelop.spring.cloud.demo.customer.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer_registration")
public class CustomerRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id")
    private Long registrationId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "customer_login_id")
    private CustomerLogin customerLogin;
    @Column(name = "customer_number")
    private Long customerNumber;

    public CustomerRegistration(final Registration registration) {
        registrationId = registration.getId();
        customerNumber = registration.getCustomerNumber();
        customerLogin = new CustomerLogin(registration.getLogin());
    }

    public Registration mapToDTO() {
        final Registration registration = new Registration();
        registration.setId(registrationId);
        registration.setCustomerNumber(customerNumber);
        registration.setLogin(customerLogin.mapToDTO());
        return registration;
    }


}
