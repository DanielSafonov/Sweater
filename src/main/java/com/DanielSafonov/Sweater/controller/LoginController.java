package com.DanielSafonov.Sweater.controller;

import com.DanielSafonov.Sweater.domain.User;
import com.DanielSafonov.Sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


//Контррллер авторизации
/*
@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo; //Доступ к профилям пользователей

    @GetMapping("/login")
    public String login(){
        return "login"; //Вернуть страницу авторизации
    }

    @PostMapping("/login")
    public String tryLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        User user = userRepo.findByUsername(username); //Поиск пользователя с таким логином в базе

        if(password.equals(user.getPassword())){
            //Пользователь существует и пароли совпадают

        }

        return "login";
    }

}
*/