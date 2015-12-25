package org.tuxdevelop.spring.cloud.demo.order.service.configuration;

import javax.ws.rs.Path;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.order.service.service.OrderServiceBean;

@Component
@Path("/orderservice")
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		register(OrderServiceBean.class);
	}

}
