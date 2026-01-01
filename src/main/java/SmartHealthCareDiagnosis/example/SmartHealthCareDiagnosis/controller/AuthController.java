package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.controller;

import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model.User;
import SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String fullName,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam Integer age,
                         @RequestParam String gender,
                         @RequestParam String phone,
                         Model model) {

        if (userService.emailExists(email)) {
            model.addAttribute("error", "Email already registered!");
            return "signup";
        }

        User user = new User(fullName, email, password, age, gender, phone);
        userService.registerUser(user);

        model.addAttribute("success", "Registration successful! Please login.");
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        Optional<User> user = userService.loginUser(email, password);

        if (user.isPresent()) {
            session.setAttribute("userId", user.get().getId());
            session.setAttribute("userName", user.get().getFullName());
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}