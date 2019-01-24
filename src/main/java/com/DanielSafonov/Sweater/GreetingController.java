package com.DanielSafonov.Sweater;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.DanielSafonov.Sweater.domain.Message;
import com.DanielSafonov.Sweater.repos.MessageRepo;

@Controller //Класс-контроллер обрабатывает HTTP-запросы
public class GreetingController {
    @Autowired //Автосвязывание
    private MessageRepo messageRepo;

    @GetMapping("/greeting") //Обработка GET запросов на /greeting вызовом метода greeting()
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model){
        //Аннотация описывает параметр запроса name (не обязателен, стандартное значение - World) (?name=Daniel)
        //Второй входной параметр метода - карта строка-объект - Model (модель)

        model.put("name", name); //Передача в модель параметра name
        return "greeting"; //Возвращает имя View (веб-страницы)

    }

    @GetMapping //Обработка GET запросов на корневом адресе
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll(); //Получение всех данные из таблицы
        model.put("messages", messages); //Передача данных в модель

        return "main";
    }

    @PostMapping //Обработка POST запроса на корневом адресе
    public String addMessage(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        //Принимает на вход две строки и модель

        Message message = new Message(text, tag); //Новое сообщение
        messageRepo.save(message); //Сохранить сообщение в БД

        Iterable<Message> messages = messageRepo.findAll(); //Получение всех данные из таблицы
        model.put("messages", messages); //Передача данных в модель

        return "main";
    }
}