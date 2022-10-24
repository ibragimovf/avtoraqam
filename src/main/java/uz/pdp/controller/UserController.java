package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getLogin(
    ) {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("password") String password
    ) {
        if (userService.login(phoneNumber, password)) {
            if (userService.isAdmin(phoneNumber, password)) {
                return "redirect: /adminPage";
            }
            return "redirect: /home";
        } else {
            return "redirect: /";
        }
    }


    @GetMapping("/yurRegister")
    public String getYurRegister(
    ) {
        return "yurRegister";
    }

    @GetMapping("/fizRegister")
    public String getFizRegister(
    ) {
        return "fizRegister";
    }

    @PostMapping("/registerFiz")
    public String fizRegister(
            @RequestParam("fullName") String fullName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("password") String password,
            @RequestParam("balance") Double balance
    ) {
        if (userService.fizRegister(fullName, phoneNumber, password, balance)) {
            return "redirect: /";
        } else {
            return "redirect: /fizRegister";
        }
    }

    @PostMapping("/registerYur")
    public String yurRegister(
            @RequestParam("fullName") String fullName,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("password") String password,
            @RequestParam("balance") Double balance
    ) {
        if (userService.yurRegister(fullName, phoneNumber, password, balance)) {
            return "redirect: /";
        } else {
            return "redirect: /yurRegister";
        }
    }

}
