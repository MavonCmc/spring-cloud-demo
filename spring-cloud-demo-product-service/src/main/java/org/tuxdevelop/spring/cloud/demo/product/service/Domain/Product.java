package org.tuxdevelop.spring.cloud.demo.product.service.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

    public Product(final ProductDTO productDTO) {
        this.productId = productDTO.getId();
        this.description = productDTO.getDescription();
        this.price = productDTO.getPrice();
    }

    public ProductDTO mapToDTO() {
        final ProductDTO productDTO = new ProductDTO();
        productDTO.setId(productId);
        productDTO.setDescription(description);
        productDTO.setPrice(price);
        return productDTO;
    }

}
