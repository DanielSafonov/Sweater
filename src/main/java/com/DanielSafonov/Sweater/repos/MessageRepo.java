package com.DanielSafonov.Sweater.repos;

import org.springframework.data.repository.CrudRepository;

import com.DanielSafonov.Sweater.domain.Message;

import java.util.List;

//Доступ к сообщениям
//Интерфейс для работы с БД
//Наследует CRUD-функционал
public interface MessageRepo extends CrudRepository<Message, Long> {
    List<Message> findAllByTag(String tag); //Метод поиска сообщений по тэгу
}
