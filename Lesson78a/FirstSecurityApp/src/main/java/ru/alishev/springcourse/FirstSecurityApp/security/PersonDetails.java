/**
 * Создал Андрей Антонов 08.08.2022 17:31
 **/
package ru.alishev.springcourse.FirstSecurityApp.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;

import java.util.Collection;

public class PersonDetails implements UserDetails  {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    /** методы из UserDetails которые нужны для секюрити */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // будем получать роли которые есть у пользователя
    }

    @Override
    public String getPassword() {
        return this.person.getPassword();
    }

    @Override
    public String getUsername() {
        return this.person.getUsername();
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

    /** нужно, чтобы получать данные аутентифицированного пользователя */
    public Person getPerson(){
        return this.person;
    }
}
