package dev.nickzs.CadastroDeUsuario.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/Greetings")
    public String Greetings(){
        return "This is my first message in this route.";
    }

    @PostMapping("/add")
    public String addUser(){
        return "User added";
    }

    @GetMapping("/allUsers")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/allID")
    public String getUserByID(){
        return "";
    }

    @PutMapping("/update")
    public String updateUser(){
        return "";
    }

    @DeleteMapping("/delete")
    public String deleteUser(){
        return "";
    }


}
