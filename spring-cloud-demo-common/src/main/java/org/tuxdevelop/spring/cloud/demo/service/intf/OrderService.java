package org.tuxdevelop.spring.cloud.demo.service.intf;

import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

import javax.ws.rs.*;
import java.util.List;

@Path("/orders")
@Produces("application/json")
@Consumes("application/json")
public interface OrderService {

    @GET
    @Path("/{orderid}")
    Order get(@PathParam("orderid") final Long orderId);

    @GET
    @Path("/customers/{customernumber}")
    List<Order> getByCustomerNumber(@PathParam("customernumber") final Long customerNumber);
}
