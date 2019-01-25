package com.DanielSafonov.Sweater.domain;

import javax.persistence.*;

//Хранит сообщения пользователей
@Entity  //Класс-сущность базы данных (Может хранить строку из таблицы)
@Table(name = "msgs")
public class Message {
    //Поля класса
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Автоматическая генерация ID
    private Long id; //Первичный ключ таблицы генерируется автоматически

    private String text;
    private String tag;


    //Конструкторы
    public Message(){ } //Пустой конструктор для Spring`а

    public Message(String text, String tag){
        this.text = text;
        this.tag = tag;
    }

    //Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    //Геттеры
    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }
}
