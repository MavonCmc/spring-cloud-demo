package org.tuxdevelop.spring.cloud.demo.customer.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tuxdevelop.spring.cloud.demo.customer.service.logic.CustomerLogicBean;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;

@RestController
@RequestMapping(value = "/customers", produces = "application/json")
public class CustomerServiceBean {

    private final CustomerLogicBean customerLogicBean;

    @Autowired
    public CustomerServiceBean(final CustomerLogicBean customerLogicBean) {
        this.customerLogicBean = customerLogicBean;
    }

    @RequestMapping(value = "/{customernumber}", method = RequestMethod.GET)
    public Customer get(@PathVariable(value = "customernumber") final Long customerNumber) {
        return customerLogicBean.get(customerNumber);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public Customer save(@RequestBody final Customer customer) {
        return customerLogicBean.save(customer);
    }

}
