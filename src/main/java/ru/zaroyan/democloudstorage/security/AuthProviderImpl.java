package ru.zaroyan.democloudstorage.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.zaroyan.democloudstorage.services.PersonDetailsService;

import java.util.Collections;

/**
 * @author Zaroyan
 */
@Component
public class AuthProviderImpl implements AuthenticationProvider {
    private final PersonDetailsService personDetailsService;

    public AuthProviderImpl(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserDetails userDetails = personDetailsService.loadUserByUsername(authentication.getName());
        String password = authentication.getCredentials().toString();
        if (!password.equals(userDetails.getPassword()))
            throw new BadCredentialsException("Неверный пароль");
        return new UsernamePasswordAuthenticationToken(userDetails,password,
                Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
