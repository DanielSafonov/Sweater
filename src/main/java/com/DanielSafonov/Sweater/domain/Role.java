package com.DanielSafonov.Sweater.domain;

import org.springframework.security.core.GrantedAuthority;

//Перечисление с ролями пользователей
public enum Role implements GrantedAuthority {
    USER, ADMIN;

    //Реализация методов интерфейса GrantedAuthority
    @Override
    public String getAuthority() {
        return name(); //Строковое представление элемента множества
    }
}
