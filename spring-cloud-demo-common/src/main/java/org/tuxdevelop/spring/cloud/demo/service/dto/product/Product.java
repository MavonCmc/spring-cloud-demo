package org.tuxdevelop.spring.cloud.demo.service.dto.product;

import lombok.*;
import org.tuxdevelop.spring.cloud.demo.service.dto.common.CommonPojo;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product extends CommonPojo {

    private String description;
    private Double price;

}
