package com.example.memberboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser() {
        // 로그인 후 대시보드 페이지로 리다이렉트
        return "redirect:/dashboard";
    }

    @RequestMapping("/dashboard")
    public String showDashboard(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "dashboard";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/dashboard";
    }
}
