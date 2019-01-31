package com.DanielSafonov.Sweater.controller;

import com.DanielSafonov.Sweater.domain.Role;
import com.DanielSafonov.Sweater.domain.User;
import com.DanielSafonov.Sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user") //Общий мэппинг для всех методов класса
public class UserController {
    @Autowired
    private UserRepo userRepo; //Доступ к профилям пользователей


    @GetMapping
    //Список пользователей системы
    public String userList(Model model){

        model.addAttribute("users", userRepo.findAll()); //Поместить в модель всех пользователей системы

        return "userList";
     }

     @GetMapping("{user}") //user/{userID}
     //Получение и правка данных конктреного пользователя
     public String userEditForm(
             @PathVariable User user,
             Model model
     ){ //Spring сам сопоставит получаемый id и пользователя
        model.addAttribute("user", user); //Поместить проофиль пользователя в модель
        model.addAttribute("roles", Role.values()); //Поместить все доступные роли в модель
        return "userEdit";
     }

    @PostMapping
    //Сохранение внесенных в профиль пользователя изменений
    public String userEditSave(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam("userID") User user,
            @RequestParam Map<String, String> formData
    ){
        //Правка данных пользователя
        user.setUsername(username);
        user.setPassword(password);

        //TODO: разрбрать код
        //Множество возможных ролей
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for(String key: formData.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user); //Сохранение изменений

        return "redirect:/user";
    }

}
