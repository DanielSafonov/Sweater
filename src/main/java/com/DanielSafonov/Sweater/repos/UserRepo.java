package com.DanielSafonov.Sweater.repos;

import com.DanielSafonov.Sweater.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


//Доступ к профилям пользователей
//Интерфейс для работы с БД
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);  //Метод поиска профиля по username
    User findByEmail(String email); //Метод поиска профиля по email
}
