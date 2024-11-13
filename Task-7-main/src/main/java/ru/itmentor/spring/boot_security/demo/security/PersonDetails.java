package ru.itmentor.spring.boot_security.demo.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itmentor.spring.boot_security.demo.models.Person;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails( Person person) {
        this.person = person;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        //акк не просрочен если True
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //не заблокирован
        //в этих методах можем менять значение в зависимости от нужды
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //пароль не просрочен
        return true;
    }

    @Override
    public boolean isEnabled() {
        //акк работает
        return true;
    }


    public Person getPerson() {
        return this.person;
    }
}
