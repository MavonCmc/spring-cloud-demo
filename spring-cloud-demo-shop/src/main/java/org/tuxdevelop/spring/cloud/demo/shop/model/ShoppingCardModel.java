package org.tuxdevelop.spring.cloud.demo.shop.model;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.Product;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session")
public class ShoppingCardModel {

    @Getter
    private Map<Product, Integer> productMap;

    public ShoppingCardModel() {
        productMap = new HashMap<>();
    }

    public void addProduct(final Product product) {
        if (productMap.containsKey(product)) {
            final Integer currentCount = productMap.get(product);
            productMap.put(product, currentCount + 1);
        } else {
            productMap.put(product, 1);
        }
    }

    public void removeProduct(final Product product) {
        productMap.remove(product);
    }

    public Double getTotalPrice() {
        Double calcPrice = 0D;
        for (final Map.Entry<Product, Integer> entry : productMap.entrySet()) {
            final Product product = entry.getKey();
            calcPrice += product.getPrice() * entry.getValue();
        }
        return calcPrice;
    }

}
