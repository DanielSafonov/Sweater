package com.DanielSafonov.Sweater.controller;

import com.DanielSafonov.Sweater.domain.Role;
import com.DanielSafonov.Sweater.domain.User;
import com.DanielSafonov.Sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user") //Общий мэппинг для всех методов класса
@PreAuthorize("hasAuthority('ADMIN')") //Доступ к контроллеру только для пользователя с ролью ADMIN
public class UserController {
    @Autowired
    private UserRepo userRepo; //Доступ к профилям пользователей


    @GetMapping
    //Список пользователей системы
    public String userList(Model model){

        model.addAttribute("users", userRepo.findAll()); //Поместить в модель всех пользователей системы

        return "userList";
     }

     @GetMapping("{user}") // user/{userID}
     //Получение и правка данных конктреного пользователя
     public String userEditForm(
             @PathVariable User user,
             Model model
     ){ //Spring сам сопоставит получаемый id и пользователя
        model.addAttribute("user", user); //Поместить проофиль пользователя в модель
        model.addAttribute("roles", Role.values()); //Поместить все доступные роли в модель
        return "userEdit";
     }

     @GetMapping("/delete/{user}") // user/delete/{userID}
     //Удаление пользователя
     public String userDelete(@PathVariable User user){
         //Удалить пользователя из БД
         userRepo.deleteById(user.getId());
         return "redirect:/user";
     }

    @PostMapping
    //Сохранение внесенных в профиль пользователя изменений
    public String userEditSave(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam("userID") User user,
            @RequestParam Map<String, String> formData
    ){
        //Правка данных пользователя
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        //Множество возможных ролей
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        //Форма возвращает перечисление ролей, обходим их
        for(String key: formData.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user); //Сохранение изменений

        return "redirect:/user";
    }

}
