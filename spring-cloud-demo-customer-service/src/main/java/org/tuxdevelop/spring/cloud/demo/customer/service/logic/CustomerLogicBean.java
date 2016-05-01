package org.tuxdevelop.spring.cloud.demo.customer.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.customer.service.domain.Customer;
import org.tuxdevelop.spring.cloud.demo.customer.service.domain.CustomerRegistration;
import org.tuxdevelop.spring.cloud.demo.customer.service.exception.NoSuchCustomerException;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.CustomerRegistrationRepository;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.CustomerRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;

@Component
public class CustomerLogicBean {

    private final CustomerRepository customerRepository;
    private final CustomerRegistrationRepository customerRegistrationRepository;

    @Autowired
    public CustomerLogicBean(final CustomerRepository customerRepository,
                             final CustomerRegistrationRepository customerRegistrationRepository) {
        this.customerRepository = customerRepository;
        this.customerRegistrationRepository = customerRegistrationRepository;
    }

    public CustomerDTO save(final CustomerDTO customerDTO) {
        final Customer customer = new Customer(customerDTO);
        customer.validatAdd();
        return customerRepository.save(customer).mapToDTO();
    }

    public CustomerDTO get(final Long customerNumber) {
        final Customer customer = customerRepository.findOne(customerNumber);
        if (customer == null) {
            throw new NoSuchCustomerException("The Customer with the customerId: " + customer + " does not exist");
        }
        return customer.mapToDTO();
    }

    public CustomerDTO searchByUserName(final String userName) {
        final CustomerRegistration customerRegistration = customerRegistrationRepository.findByCustomerLoginUserName(userName);
        final CustomerDTO customerDTO;
        if (customerRegistration != null) {
            final Long customerNumber = customerRegistration.getCustomerNumber();
            customerDTO = get(customerNumber);
        } else {
            throw new NoSuchCustomerException("The Customer with the user name: " + userName + " does not exist");
        }
        return customerDTO;
    }

    //TODO business validation
    public void delete(final CustomerDTO customerDTO) {
        customerRepository.delete(customerDTO.getId());
    }


}
