package com.DanielSafonov.Sweater.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //Файл конфигурации для привязки login к /login (привязка view-контроллеров к view)
public class MvcConfig implements WebMvcConfigurer {
    //Получает путь из application.properties и вставляет его в переменную
    @Value("${upload.path}")
    private String uploadPath;

    //Привязка view к controller (сгенерированному автоматически)
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
        //Все остальные View уже замеппили
    }

    //Каждое обращение к серверу по пути img перенаправляет все запросы по другому пути (протокол file)
    //Вся иерархия директории static раздается, файлы ищутся в дереве проекта /static
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file://" + uploadPath + "/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
