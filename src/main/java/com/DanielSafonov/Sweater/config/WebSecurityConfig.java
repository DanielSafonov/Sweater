package com.DanielSafonov.Sweater.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration //Файл конфигурации Spring Security
@EnableWebSecurity //Включить и сконфигурировать Web Security
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override  //Переопределение метода конфигурации Web Security (какие пути открыты, а какие нет)
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
        //Включить авторизацию
        //К корневому адресу (/) разрешен полный доступ
        //Для всех остальных запросов требуется авторизация
        //Включаем login
        //По адресу /login
        //Разрешаем доступ к форме для всех
        //Включаем logout
        //Разрешаем доступ для всех
    }

    //Создание в памяти менеджера пользователей с одним пользователем (без шифрования пароля и сохранения в базу)
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }
}
