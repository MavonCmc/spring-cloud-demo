package org.tuxdevelop.spring.cloud.demo.shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration {


    @Configuration
    static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

        private AuthenticationManager remoteAuthenticationManager;

        @Autowired
        public void setRemoteAuthenticationManager(final AuthenticationManager remoteAuthenticationManager) {
            this.remoteAuthenticationManager = remoteAuthenticationManager;
        }

        @Override
        public void configure(final HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/", "/index", "/registrations", "/login", "/img/**", "/hystrix.stream", "/hystrix/**",
                            "/management/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginPage("/login")
                    .and()
                    .logout()
                    .permitAll();
        }

        @Override
        protected AuthenticationManager authenticationManager() throws Exception {
            return remoteAuthenticationManager;
        }
    }

}
