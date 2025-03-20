package dev.nickzs.CadastroDeUsuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class Controller {

    @GetMapping("/Greetings")
    public String Greetings(){
        return "This is my first message in this route.";
    }

}
