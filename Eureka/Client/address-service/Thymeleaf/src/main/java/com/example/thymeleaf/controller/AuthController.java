package com.example.thymeleaf.controller;

import com.example.thymeleaf.dto.UserDto;
import com.example.thymeleaf.entity.Users;
import com.example.thymeleaf.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {

    private UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){

        return "index";
    }
    // handler method to handle login request
    @GetMapping("/login")
    public String login(){

        return "login";
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        Users user = new Users();
        model.addAttribute("user", user);
        return "register";
    }
    //BindingResult ] is Spring's object that holds the result of the validation and binding and contains errors
    // that may have occurred. The
    // BindingResult must come right after the model object that is validated
    // or else Spring will fail to validate the object and throw an exception.
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        Users existingUser = userService.findUserByEmail(userDto.getEmail());

//        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
//            result.rejectValue("email", null,
//                    "There is already an account registered with the same email");
//        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<Users> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
