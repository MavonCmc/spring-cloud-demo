package org.tuxdevelop.spring.cloud.demo.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.customer.CustomerAdapter;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.order.OrderAdapter;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerAdapter customerAdapter;
    private final OrderAdapter orderAdapter;

    @Autowired
    public CustomerController(final CustomerAdapter customerAdapter,
                              final OrderAdapter orderAdapter) {
        this.customerAdapter = customerAdapter;
        this.orderAdapter = orderAdapter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void init(final Model model) {
        final CustomerDTO customerDTO = customerAdapter.findCustomer();
        final List<Order> customerOrders = orderAdapter.getOrdersByCustomerNumber(customerDTO.getId());
        model.addAttribute("customer", customerDTO);
        model.addAttribute("orders", customerOrders);
    }


}
