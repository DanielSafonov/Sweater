package com.DanielSafonov.Sweater.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import com.DanielSafonov.Sweater.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DanielSafonov.Sweater.domain.Message;
import com.DanielSafonov.Sweater.repos.MessageRepo;
import org.springframework.web.multipart.MultipartFile;

//Главный контроллер
@Controller //Класс-контроллер обрабатывает HTTP-запросы
public class MainController {
    @Autowired //Автосвязывание
    private MessageRepo messageRepo; //Репозиторий для работы с сообщениями

    //Получает путь из application.properties и вставляет его в переменную
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/") //Обработка GET запросов на корневой адрес вызовом метода greeting()
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="user") String name,
            Map<String, Object> model
    ){
        //Аннотация описывает параметр запроса name (не обязателен, стандартное значение - World) (?name=Daniel)
        //Второй входной параметр метода - карта строка-объект - Model (модель)

        model.put("name", name); //Передача в модель параметра name
        return "greeting"; //Возвращает имя View (веб-страницы)

    }

    @GetMapping("/home") //Обработка GET запросов на /main
    public String main(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model
    ){
        //Принимаем на вход фильтр для сообщений и модель

        //Вывод сообщений
        Iterable<Message> messages; //Список сообщений


        //Фильтр сообщений
        if(filter == null || filter.isEmpty()){
            //Фильтр не задан - вывести все
            messages = messageRepo.findAll(); //Получение всех данные из таблицы
        } else{
            //Фильтра задан - поиск по тегу
            messages = messageRepo.findAllByTag(filter); //Получить все данные из таблицы по фильтру
        }

        //Передача данных в модель
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);


        return "home"; //Возвращает имя View (веб-страницы)
    }

    @PostMapping("/home") //Обработка POST запроса на /main
    public String addMessage(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            @RequestParam("file") MultipartFile file,
            Map<String, Object> model
    ) throws IOException {
        //Принимает на вход профиль авторизированного пользователя, две строки, файл и модель

        Message message = new Message(text, tag, user); //Новое сообщение

        //Если файл существует, добавляем его к сообщению
        if(file != null && !file.getOriginalFilename().isEmpty()){
            File uploadFolder = new File(uploadPath); //Объект директории загрузки
            //Создать директорию, если ее не сущесвует
            if(!uploadFolder.exists()){
                uploadFolder.mkdir();
            }
            //Уникальный идентификатор файла
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            //Загрузка файла
            file.transferTo(new File(uploadFolder + "/" + resultFilename));
            //Добавляем файл к сообщению
            message.setFilename(resultFilename);
        }

        messageRepo.save(message); //Сохранить сообщение в БД

        Iterable<Message> messages = messageRepo.findAll(); //Получение всех данные из таблицы
        model.put("messages", messages); //Передача данных в модель
        model.put("filter", ""); //Пустой фильтр


        return "home"; //Возвращает имя View (веб-страницы)
    }
}