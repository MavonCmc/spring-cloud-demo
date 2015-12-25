package org.tuxdevelop.spring.cloud.demo.service.intf;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

@Path("/orders")
@Produces("application/json")
@Consumes("application/json")
public interface OrderService {

	@POST
	Order save(final Order order);

	@GET
	@Path("/{orderId}")
	Order get(@PathParam("orderId") final Long orderId);

}
