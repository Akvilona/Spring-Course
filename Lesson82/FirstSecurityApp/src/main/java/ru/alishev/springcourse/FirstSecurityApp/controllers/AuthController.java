/**
 * Создал Андрей Антонов 07.08.2022 12:06
 **/
package ru.alishev.springcourse.FirstSecurityApp.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;
import ru.alishev.springcourse.FirstSecurityApp.services.RegistrationService;
import ru.alishev.springcourse.FirstSecurityApp.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final RegistrationService registrationService;
    private final PersonValidator personValidator;

    @Autowired
    public AuthController(RegistrationService registrationService, PersonValidator personValidator) {
        this.registrationService = registrationService;
        this.personValidator = personValidator;
    }

    /** форма для аутентификации пользователя */
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    /** форма для заведения нового пользователя */
    @GetMapping("/registration")
    public String registrationPage (@ModelAttribute("person") Person person) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration (@ModelAttribute("person") @Valid Person person,
                                       BindingResult bindingResult) {
        /**Проверяем что человек с таким именем уже есть
         * и так как человек не сможет зарегистрироваться
         * с таким именем, которое уже существует, выводим сообщение */
        personValidator.validate(person, bindingResult);

        /** после проверки валидации нужно отследить ошибки */
        if (bindingResult.hasErrors())
            return "/auth/registration";

        /** сохраняем нового человека */
        registrationService.register(person);

        return "redirect:/auth/login";
    }
}