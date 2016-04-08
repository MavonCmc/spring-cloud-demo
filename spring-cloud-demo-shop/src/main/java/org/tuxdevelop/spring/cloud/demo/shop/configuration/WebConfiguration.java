package org.tuxdevelop.spring.cloud.demo.shop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration {

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(final ViewControllerRegistry viewControllerRegistry) {
                viewControllerRegistry.addViewController("/").setViewName("index");
                viewControllerRegistry.addViewController("/index").setViewName("index");
                viewControllerRegistry.addViewController("/login").setViewName("login");
                viewControllerRegistry.addViewController("/registrations").setViewName("registrations");
                viewControllerRegistry.addViewController("/shop").setViewName("shop");
                viewControllerRegistry.addViewController("/checkout").setViewName("checkout");
                viewControllerRegistry.addViewController("/customers").setViewName("customers");
            }
        };
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
