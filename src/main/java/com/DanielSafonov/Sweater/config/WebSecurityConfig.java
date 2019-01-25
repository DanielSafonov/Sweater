package com.DanielSafonov.Sweater.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration //Файл конфигурации Spring Security
@EnableWebSecurity //Включить и сконфигурировать Web Security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired //Автосвязывание
    private DataSource dataSource;

    @Override  //Переопределение метода конфигурации доступа к ресурсам
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
        //Включить авторизацию
        //К корневому адресу (/) и форме решистрации (/registration) разрешен полный доступ
        //Для всех остальных запросов требуется авторизация
        //Включаем login
        //По адресу /login разрешаем доступ для всех
        //Включаем logout
        //Разрешаем доступ для всех
    }

    @Override //Переопределение метода концигурации аутентификации и работы с БД
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .usersByUsernameQuery("select username, password, active from usr where username = ?")
                .authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join usr_role ur on u.id = ur.usr_id where u.username=?");
        //Менеджер может заходить в БД через dataSource и искать там логины/пароли
        //Шифрование паролей отключено
        //Запрос к БД в виде SQL (поиск пользовователя по username)
        //Запрос к БД в виде SQL (полеучение пользователя с его ролью по id)
    }
}
