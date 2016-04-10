package org.tuxdevelop.spring.cloud.demo.customer.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tuxdevelop.spring.cloud.demo.customer.service.logic.CustomerLogicBean;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;

@RestController
@RequestMapping(value = "/customers", produces = "application/json")
public class CustomerServiceBean {

    private final CustomerLogicBean customerLogicBean;

    @Autowired
    public CustomerServiceBean(final CustomerLogicBean customerLogicBean) {
        this.customerLogicBean = customerLogicBean;
    }

    @RequestMapping(value = "/{customernumber}", method = RequestMethod.GET)
    public CustomerDTO get(@PathVariable(value = "customernumber") final Long customerNumber) {
        return customerLogicBean.get(customerNumber);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public CustomerDTO save(@RequestBody final CustomerDTO customerDTO) {
        return customerLogicBean.save(customerDTO);
    }

    @RequestMapping(value = "/search")
    public CustomerDTO searchByUserName(@RequestParam(name = "username") final String userName) {
        return customerLogicBean.searchByUserName(userName);
    }

}
