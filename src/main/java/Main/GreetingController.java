package Main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller //Класс-контроллер обрабатывает HTTP-запросы
public class GreetingController {

    @GetMapping("/greeting") //Обрабатывает GET запросы на /greeting вызовом метода greeting()
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model){
        //Аннотация описывает параметр запроса name (не обязателен, стандартное значение - World) (?name=Daniel)
        //Второй входной параметр метода - карта строка-объект - Model (модель)

        model.put("name", name); //Передача в модель параметра name
        return "greeting"; //Возвращает имя View (веб-страницы)

    }

    @GetMapping //Обработка GET запрсов на корневой ресурс
    public String main(Map<String, Object> model){
        //Не принимает никаких параметров из запроса
        model.put("output", "some..");
        return "main"; //Возвращает имя View (веб-страницы)
    }
}