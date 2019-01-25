package com.DanielSafonov.Sweater.service;

import com.DanielSafonov.Sweater.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service //Класс-сервис
public class UserService implements UserDetailsService {
    @Autowired //Автосвязывание сервиса и репозитория доступа к профилям пользоввателей
    private UserRepo userRepo;

    @Override //Переопределение метода возврата профиля пользователя по username
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
}
