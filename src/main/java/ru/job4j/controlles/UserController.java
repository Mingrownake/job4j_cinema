package ru.job4j.controlles;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.job4j.models.User;
import ru.job4j.repository.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLogin() {
        return "users/login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute User user, Model model, HttpServletRequest request) {
        var optionalUser = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());
        if (optionalUser.isEmpty()) {
            model.addAttribute("error", "Логин или пароль введён некорректно.");
            return "users/login";
        }
        var session = request.getSession();
        session.setAttribute("user", optionalUser.get());
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/users/login";
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "users/register";
    }

    @PostMapping("/registration")
    public String postRegistration(@ModelAttribute User user, Model model) {
        var newUser = userService.save(user);
        if (newUser.isEmpty()) {
            model.addAttribute("message", "Пользователь с данным email: " + user.getEmail()
            + " уже зарегистрирован");
            return "errors/404";
        }
        return "redirect:/index";
    }
}
