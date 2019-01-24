package com.DanielSafonov.Sweater.repos;

import org.springframework.data.repository.CrudRepository;

import com.DanielSafonov.Sweater.domain.Message;

//Интерфейс для работы с БД
//Наследует CRUD-функционал
public interface MessageRepo extends CrudRepository<Message, Integer> {
}
