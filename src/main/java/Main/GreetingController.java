package Main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //Класс-контроллер обрабатывает HTTP-запросы
public class GreetingController {

    @GetMapping("/greeting") //Обрабатывает GET запросы на /greeting вызовом метода greeting()
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        //Аннотация описывает параметр запроса name (не обязателен, стандартное значение - World) (?name=Daniel)
        //Второй входной параметр метода - Model (модель)

        model.addAttribute("name", name); //Передача в модель параметра name
        return "greeting"; //Возвращает имя View (веб-страницы)

    }

}