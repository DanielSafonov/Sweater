package com.DanielSafonov.Sweater.controller;

import com.DanielSafonov.Sweater.domain.Role;
import com.DanielSafonov.Sweater.domain.User;
import com.DanielSafonov.Sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class ProfileController {
    @Autowired
    private UserRepo userRepo; //Доступ к профилям пользователей

    @GetMapping("/profile")
    //Личный кабинет пользователя
    public String userProfile(
            @AuthenticationPrincipal User user,
            Model model
    ){
        model.addAttribute("user", user); //Поместить проофиль пользователя в модель
        model.addAttribute("roles", Role.values()); //Поместить все доступные роли в модель
        return "profile";
    }

    @PostMapping("/profile")
    //Внесение изменений в личном кабинете
    public String editUserProfile(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam("userID") User user
    ){
        //Правка данных пользователя
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        userRepo.save(user); //Сохранение изменений

        return "profile";
    }

}
