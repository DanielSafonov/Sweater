package com.DanielSafonov.Sweater.controller;

import com.DanielSafonov.Sweater.domain.Role;
import com.DanielSafonov.Sweater.domain.User;
import com.DanielSafonov.Sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Map;

//Контроллер регистрации
@Controller //Класс-контроллер обрабатывает HTTP-запросы
public class RegistrationController {
    @Autowired //Автосвязывание
    private UserRepo userRepo; //Репозиторий для работы с профилями пользователей

    @GetMapping("/registration") //Обработка GET запросов на адрес /registration вызовом метода registration()
    public String registration(Model model){
        return "registration"; //Возвращает имя View (веб-страницы)
    }

    @PostMapping("/registration") //Обработка POST запроса на /registration
    public String addUser(User user, Map<String, Object> model){
        //Проверки на существование пользователя с такими данными
        User userFromDb = userRepo.findByUsername(user.getUsername()); //Поиск такого username в базе
        if(userFromDb != null){
            //Username занят
            model.put("message", "Пользователь с таким username уже существует!"); //Передача строки в модель
            return "registration"; //Возврат на страницу регистрациии
        }

        userFromDb = userRepo.findByEmail(user.getUsername());

        if(userFromDb != null){
            //Email занят
            model.put("message", "Пользователь с таким email уже существует!"); //Передача строки в модель
            return "registration"; //Возврат на страницу регистрациии
        }

        //Username и email не заняты
        user.setActive(true); //Активация пользователя
        HashSet<Role> roles = new HashSet<Role>(); //Множество ролей пользовотеля
        roles.add(Role.USER); //Добавление роли "Пользователь"
        user.setRoles(roles); //Добавление роли пользователю
        userRepo.save(user); //Сохранить пользователя в БД

        return "redirect:/login"; //Редирект на страницу авторизации
    }
}
