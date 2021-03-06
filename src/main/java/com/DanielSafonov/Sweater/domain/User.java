package com.DanielSafonov.Sweater.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

//Хранит профили пользователей
@Entity  //Класс-сущность базы данных (Может хранить строку из таблицы)
@Table(name = "usr")
public class User implements UserDetails {
    //Поля класса
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Автоматическая генерация ID
    private Long id; //Первичный ключ таблицы генерируется автоматически

    private String username; //Логин
    private String password; //Пароль
    private boolean active; //Признак активности
    private String firstName; //Имя
    private String lastName; //Фамилия
    private String email; //Email

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

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getName() { return  firstName + " " + lastName; }

    public String getEmail() { return email; }

    public Set<Role> getRoles() { return roles; }

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    //Реализация методов интерфейса UserDetails (большая часть - заглушки)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    //Проверка на администратора
    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }
}
