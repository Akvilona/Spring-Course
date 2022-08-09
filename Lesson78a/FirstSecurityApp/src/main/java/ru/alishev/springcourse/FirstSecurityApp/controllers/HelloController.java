/**
 * Создал Андрей Антонов 08.08.2022 15:50
 **/
package ru.alishev.springcourse.FirstSecurityApp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alishev.springcourse.FirstSecurityApp.security.PersonDetails;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "hello";
    }

    /** организуем этот метод, который имеет доступ к JAVA потоку,
     * чтобы получить данные о пользователе  */
    @GetMapping("/showUserInfo")
    public String showUserInfo() {

        /** получаем доступ к объекту Authentication при помощи getAuthentication() это потоке
         * SecurityContextHolder - из сессии пользователя достал "SpringSecurity"
         * поместил его в этот getContext() для этого пользователя, в этом getAuthentication() потоке */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        /** теперь получим доступ к этому пользователю personDetails из authentication */
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        /** получили из принципала personDetails и теперь на из personDetails.getPerson()
         * и выведем человека на экран */
        System.out.println(personDetails.getPerson());

        return "hello";
    }
}
