package org.tuxdevelop.spring.cloud.demo.customer.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_number")
    private Long customerNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "iso_country_code")
    private String isoCountryCode;
    @Column(name = "email_address")
    private String emailAddress;

    public Customer(final CustomerDTO customerDTO) {
        this.customerNumber = customerDTO.getId();
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.isoCountryCode = customerDTO.getIsoCountryCode();
        this.emailAddress = customerDTO.getEmailAddress();
    }

    public CustomerDTO mapToDTO() {
        final CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customerNumber);
        customerDTO.setFirstName(firstName);
        customerDTO.setLastName(lastName);
        customerDTO.setIsoCountryCode(isoCountryCode);
        customerDTO.setEmailAddress(emailAddress);
        return customerDTO;
    }

    public void validatAdd() {
        assert customerNumber == null : "customerId must not be set for add!";
        validateCommon();
    }

    public void validateUpdate() {
        assert customerNumber != null : "customerId must not be null!";
        validateCommon();
    }

    private void validateCommon() {
        assert firstName != null && !firstName.isEmpty() : "firstName must not be null or empty!";
        assert lastName != null && !lastName.isEmpty() : "lastName must not be null or empty";
        assert isoCountryCode != null && isoCountryCode.length() == 2 : "isoCountryCode must not be null and must have " +
                "the lenth of 2!";
        assert emailAddress != null && !emailAddress.isEmpty() : "emailAddress must not be null or empty!";
    }

}
