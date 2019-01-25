package com.DanielSafonov.Sweater.domain;

import javax.persistence.*;
import java.util.Set;

//Хранит профили пользователей
@Entity  //Класс-сущность базы данных (Может хранить строку из таблицы)
@Table(name = "usr")
public class User {
    //Поля класса
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Автоматическая генерация ID
    private Long id; //Первичный ключ таблицы генерируется автоматически

    private String username; //Логин
    private String password; //Пароль
    private boolean active; //Признак активности

    //Автоматическая генерация дополнительной таблицы для enum
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER) //Загрузка "жадным способом" (легкие данные)
    //Данная коллекция хранится в отдельной таблице, которая не бьла описана в мэпе
    @CollectionTable(name = "usr_role", joinColumns = @JoinColumn(name = "usr_id")) //Таблицы соединяются через usr_id
    @Enumerated(EnumType.STRING) //Данная коллекция - перечисление, которое должно храниться в виде строки
    private Set<Role> roles; //Список ролей пользователя


    //Методы класса

    //Геттеры
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active;
    }

    public Set<Role> getRoles() {
        return roles;
    }


    //Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
