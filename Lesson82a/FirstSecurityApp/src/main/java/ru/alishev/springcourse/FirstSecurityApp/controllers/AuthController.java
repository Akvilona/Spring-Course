/**
 * Создал Андрей Антонов 07.08.2022 12:06
 **/
package ru.alishev.springcourse.FirstSecurityApp.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alishev.springcourse.FirstSecurityApp.models.Person;

@Controller
@RequestMapping("/auth")
public class AuthController {

    /** форма для аутентификации пользователя */
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    /** форма для заведения нового пользователя */
    public String registrationPage (@ModelAttribute("person") Person person) {

        model.



        return "auth/registration";
    }
}
