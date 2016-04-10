package org.tuxdevelop.spring.cloud.demo.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.product.ProductAdapter;
import org.tuxdevelop.spring.cloud.demo.shop.model.ShoppingCardModel;

import java.util.List;

@Controller
@Scope("session")
@RequestMapping("/shop")
public class ShopController {

    private final ProductAdapter productAdapter;
    private final ShoppingCardModel shoppingCardModel;

    @Autowired
    public ShopController(final ProductAdapter productAdapter, final ShoppingCardModel shoppingCardModel) {
        this.productAdapter = productAdapter;
        this.shoppingCardModel = shoppingCardModel;
    }

    @RequestMapping(method = RequestMethod.GET)
    public void init(final Model model) {

        final List<ProductDTO> productDTOs = productAdapter.getAllProducts();
        model.addAttribute("products", productDTOs);
        model.addAttribute("shoppingCard", shoppingCardModel);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addProductToShoppingCard(@RequestParam("productid") final Long productId) {
        final ProductDTO productDTO = productAdapter.getById(productId);
        shoppingCardModel.addProduct(productDTO);
        return "redirect:/shop";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String removeProductFromShoppingCard(@RequestParam("productid") final Long productId) {
        final ProductDTO productDTO = productAdapter.getById(productId);
        shoppingCardModel.removeProduct(productDTO);
        return "redirect:/shop";
    }
}
