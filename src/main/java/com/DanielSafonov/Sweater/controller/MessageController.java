package com.DanielSafonov.Sweater.controller;

import com.DanielSafonov.Sweater.domain.Message;
import com.DanielSafonov.Sweater.repos.MessageRepo;
import com.DanielSafonov.Sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/message")
@PreAuthorize("hasAuthority('ADMIN')") //Доступ к контроллеру только для пользователя с ролью ADMIN
public class MessageController {
    @Autowired //Австосвязывание с репозиторием сообщений
    private MessageRepo messageRepo;

    @Autowired //Австосвязывание с репозиторием пользователей
    private UserRepo userRepo;

    //Получает путь из application.properties и вставляет его в переменную
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping
    //Список сообщений
    public String messageList(Model model){

        model.addAttribute("messages", messageRepo.findAll()); //Передать в модель все сообщения

        return "messageList";
    }

    @GetMapping("/delete/{message}") // message/delete/{messageID}
    //Удаление сообщения из списка
    public String messageListSave(@PathVariable Message message){
        //Удалить файл
        File file = new File(uploadPath + "/" + message.getFilename());
        if(file.exists()){
            file.delete();
        }
        //Удалить сообщение из БД
        messageRepo.deleteById(message.getId());
        return "redirect:/message";
    }

    @GetMapping("{message}") // message/{messageID}
    //Получение и правка сообщения по ID
    public String messageEditForm(
            @PathVariable Message message,
            Model model
    ){

        model.addAttribute("message", message); //Передать в модель сообщение по ID

        return "messageEdit";
    }

    //TODO: добавить ссылку на файл в messageList

    @PostMapping
    //Сохранений внесенных изменений в сообщений по ID
    public String messageEditSave(
            @RequestParam("messageID") Message message,
            @RequestParam String author,
            @RequestParam String tag,
            @RequestParam String text,
            @RequestParam("file") MultipartFile file
            ) throws IOException {
        message.setAuthor(userRepo.findByUsername(author)); //TODO: Если такого пользователя не существует?
        message.setTag(tag);
        message.setText(text);

        //TODO: Удалить старый файл при загрузке нового
        //TODO: Если загружается тот же самый файл?
        //Загрузка и сохранение файла
        //Если файл существует, добавляем его к сообщению
        if(file != null && !file.getOriginalFilename().isEmpty()){
            File uploadFolder = new File(uploadPath); //Объект директории загрузки
            //Создать директорию, если ее не сущесвует
            if(!uploadFolder.exists()){
                uploadFolder.mkdir();
            }
            //Уникальный идентификатор файла
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename =  uuidFile + "." + file.getOriginalFilename();
            //Загрузка файла
            file.transferTo(new File(uploadFolder + "/" + resultFilename));
            //Добавляем файл к сообщению
            message.setFilename(resultFilename);
        }

        messageRepo.save(message);

        return "redirect:/message";
    }
}
