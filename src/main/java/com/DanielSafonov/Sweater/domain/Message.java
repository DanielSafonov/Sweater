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

    private String text; //Текст сообщения
    private String tag; //Тэг сообщения
    private String filename; //Имя файла

    //Мэппинг поля автора сообщения (связь двух таблиц)
    //Связь, при которой одному пользователю соответствует множество сообщений (связь между таблицами)
    @ManyToOne(fetch = FetchType.EAGER) //Жадная загрузка
    @JoinColumn(name = "usr_id") //В таблице messages создается поле usr_id для связи
    private User author; //Автор сообщения


    //Конструкторы
    public Message(){ } //Пустой конструктор для Spring`а

    public Message(String text, String tag, User author){
        this.text = text;
        this.tag = tag;
        this.author = author;
    }

    //Метод для получения имени автора
    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }

    //Метод для получения имени сообщения
    public String getFilePath(){ return filename != null ? filename : "<none>";} //TODO: не совсем корректно работает

    //Сеттеры
    public void setId(Long id) { this.id = id; }
    public void setText(String text) {
        this.text = text;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public void setAuthor(User author) { this.author = author; }

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
    public String getFilename() {
        return filename;
    }
    public User getAuthor() { return author; }
}
