package org.tuxdevelop.spring.cloud.demo.service.dto.order;

import lombok.*;
import org.tuxdevelop.spring.cloud.demo.service.dto.common.CommonPojo;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem extends CommonPojo {

    private ProductDTO productDTO;

}
