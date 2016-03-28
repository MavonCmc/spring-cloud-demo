package org.tuxdevelop.spring.cloud.demo.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.customer.RegistrationsAdapter;

import java.util.LinkedList;


@Component
public class RemoteAuthenticationManager implements AuthenticationManager {

    private final RegistrationsAdapter registrationsAdapter;

    @Autowired
    public RemoteAuthenticationManager(final RegistrationsAdapter registrationsAdapter) {
        this.registrationsAdapter = registrationsAdapter;
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        try {
            final String userName = authentication.getPrincipal().toString();
            final String password = authentication.getCredentials().toString();
            registrationsAdapter.performLogin(userName, password);
            return new UsernamePasswordAuthenticationToken(userName, password, new LinkedList<>());
        } catch (final Exception e) {
            throw new BadCredentialsException(e.getMessage(), e);
        }

    }
}
