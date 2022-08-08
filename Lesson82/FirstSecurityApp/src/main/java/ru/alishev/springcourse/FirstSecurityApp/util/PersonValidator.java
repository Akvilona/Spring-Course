/**
 * Создал Андрей Антонов 07.08.2022 21:37
 **/
package ru.alishev.springcourse.FirstSecurityApp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;
import ru.alishev.springcourse.FirstSecurityApp.services.PersonDetailsService;

@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    /** нужен для объектов класса Person */
    @Override
     public boolean supports(Class<?> aClass ) {
        return  Person.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Person person = (Person) target;

        /** проверяем пользователя по имени в базе данных */
        try {
            personDetailsService.loadUserByUsername(person.getUsername());
        } catch (UsernameNotFoundException ignored) {
            /** Если по исключению такого пользователя нет, то пользователя можно заводить */
            return; //   все Ok, пользователь с таким именем не найден
        }
        /** если ошибки нет, значит человек с таким именем в базе уже есть */
        errors.rejectValue("username", "", "Человек с таким именем пользователя уже существует");
    }
}
