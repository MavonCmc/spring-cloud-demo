package org.tuxdevelop.spring.cloud.demo.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.OrderItem;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.customer.CustomerAdapter;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.order.OrderAdapter;
import org.tuxdevelop.spring.cloud.demo.shop.model.ShoppingCartModel;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Controller
@Scope("session")
@RequestMapping("/checkout")
public class CheckoutController {

    private final OrderAdapter orderAdapter;
    private final ShoppingCartModel shoppingCartModel;
    private final CustomerAdapter customerAdapter;

    @Autowired
    public CheckoutController(final OrderAdapter orderAdapter,
                              final ShoppingCartModel shoppingCartModel,
                              final CustomerAdapter customerAdapter) {
        this.orderAdapter = orderAdapter;
        this.shoppingCartModel = shoppingCartModel;
        this.customerAdapter = customerAdapter;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void init(final Model model) {
        model.addAttribute("shoppingCart", shoppingCartModel);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String checkout() {
        final CustomerDTO customerDTO = customerAdapter.findCustomer();
        final Order order = new Order();
        order.setCustomerId(customerDTO.getId());
        order.setOrderItems(map(shoppingCartModel.getProductMap()));
        order.setTotalPrice(shoppingCartModel.getTotalPrice());
        orderAdapter.saveOrder(order);
        shoppingCartModel.clearOrders();
        return "redirect:shop";
    }

    List<OrderItem> map(final Map<ProductDTO, Integer> products) {
        final List<OrderItem> orderItems = new LinkedList<>();
        for (final Map.Entry<ProductDTO, Integer> entry : products.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                final OrderItem orderItem = new OrderItem();
                orderItem.setProductDTO(entry.getKey());
                orderItems.add(orderItem);
            }
        }
        return orderItems;
    }
}
