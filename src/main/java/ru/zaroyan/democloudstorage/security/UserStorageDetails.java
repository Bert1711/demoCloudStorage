package ru.zaroyan.democloudstorage.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.zaroyan.democloudstorage.model.UserStorage;

import java.util.Collection;

public class UserStorageDetails implements UserDetails {

    private final UserStorage userStorage;

    public UserStorageDetails(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.userStorage.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userStorage.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
