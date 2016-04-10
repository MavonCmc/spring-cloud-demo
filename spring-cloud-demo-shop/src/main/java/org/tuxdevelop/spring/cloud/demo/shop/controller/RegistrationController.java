package org.tuxdevelop.spring.cloud.demo.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Login;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.customer.CustomerAdapter;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.customer.RegistrationsAdapter;
import org.tuxdevelop.spring.cloud.demo.shop.model.RegistrationModel;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {

    private final RegistrationsAdapter registrationsAdapter;
    private final CustomerAdapter customerAdapter;

    @Autowired
    public RegistrationController(final RegistrationsAdapter registrationsAdapter,
                                  final CustomerAdapter customerAdapter) {
        this.registrationsAdapter = registrationsAdapter;
        this.customerAdapter = customerAdapter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void init(final Model model) {
        model.addAttribute("registrationModel", new RegistrationModel(new Registration(), new CustomerDTO()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@ModelAttribute final RegistrationModel registrationModel) {
        final Login login = registrationModel.getRegistration().getLogin();
        final Boolean userNameExists = registrationsAdapter.verifyUserName(login.getUserName());
        if (userNameExists) {
            throw new IllegalArgumentException("Username already exists");
        }
        final CustomerDTO customerDTO = customerAdapter.addCustomer(registrationModel.getCustomerDTO());
        registrationsAdapter.createRegistration(customerDTO.getId(), login.getUserName(), login.getPassword());
        return "redirect:index";
    }

}
