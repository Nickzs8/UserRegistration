package dev.nickzs.CadastroDeUsuario.Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class UserController {

    @GetMapping("/Greetings")
    public String Greetings(){
        return "This is my first message in this route.";
    }

}
