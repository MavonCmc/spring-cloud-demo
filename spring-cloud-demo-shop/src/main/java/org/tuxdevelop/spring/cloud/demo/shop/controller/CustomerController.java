package org.tuxdevelop.spring.cloud.demo.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.customer.CustomerAdapter;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerAdapter customerAdapter;

    @Autowired
    public CustomerController(final CustomerAdapter customerAdapter) {
        this.customerAdapter = customerAdapter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void init(final Model model) {
        final String userName = determineUserName();
        final CustomerDTO customerDTO = customerAdapter.findCustomerByUserName(userName);
        model.addAttribute("customer", customerDTO);
    }

    private String determineUserName() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
