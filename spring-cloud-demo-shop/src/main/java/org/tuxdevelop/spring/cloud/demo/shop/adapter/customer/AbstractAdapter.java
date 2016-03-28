package org.tuxdevelop.spring.cloud.demo.shop.adapter.customer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public abstract class AbstractAdapter {

    HttpHeaders prepareHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }
}
