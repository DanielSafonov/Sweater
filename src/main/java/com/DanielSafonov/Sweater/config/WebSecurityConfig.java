package com.DanielSafonov.Sweater.config;

import com.DanielSafonov.Sweater.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration //Файл конфигурации Spring Security
@EnableWebSecurity //Включить и сконфигурировать Web Security
@EnableGlobalMethodSecurity(prePostEnabled =  true) //Включить ограниченный доступ к методам (контроллерам)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired //Автосвязывание класса-конфигурации с сервисом пользователей
    private UserService userService;

    @Override  //Переопределение метода конфигурации доступа к ресурсам
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/registration", "/static/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
        //Включить авторизацию
        //К корневому адресу (/), форме регистрации (/registration) и директории статики разрешен полный доступ
        //Для всех остальных запросов требуется авторизация
        //Включаем login
        //По адресу /login разрешаем доступ для всех
        //Включаем logout
        //Разрешаем доступ для всех
    }

    @Override //Переопределение метода концигурации аутентификации и работы с БД
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
