package org.tuxdevelop.spring.cloud.demo.shop.model;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "session")
public class ShoppingCartModel {

    @Getter
    private Map<ProductDTO, Integer> productMap;

    public ShoppingCartModel() {
        productMap = new HashMap<>();
    }

    public void addProduct(final ProductDTO productDTO) {
        if (productMap.containsKey(productDTO)) {
            final Integer currentCount = productMap.get(productDTO);
            productMap.put(productDTO, currentCount + 1);
        } else {
            productMap.put(productDTO, 1);
        }
    }

    public void removeProduct(final ProductDTO productDTO) {
        productMap.remove(productDTO);
    }

    public Double getTotalPrice() {
        Double calcPrice = 0D;
        for (final Map.Entry<ProductDTO, Integer> entry : productMap.entrySet()) {
            final ProductDTO productDTO = entry.getKey();
            calcPrice += productDTO.getPrice() * entry.getValue();
        }
        return calcPrice;
    }

    public void clearOrders() {
        productMap.clear();
    }

}
