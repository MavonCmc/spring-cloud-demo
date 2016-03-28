package org.tuxdevelop.spring.cloud.demo.service.dto.order;

import lombok.*;
import org.tuxdevelop.spring.cloud.demo.service.dto.common.CommonPojo;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class Order extends CommonPojo {

    private Long customerId;
    private Collection<OrderItem> orderItems;
    private Double totalPrice;

}
