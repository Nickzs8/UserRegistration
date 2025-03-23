package dev.nickzs.CadastroDeUsuario.Users;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/createUser")
    public UserModel addUser(@RequestBody UserModel userModel){
        return userService.createUser(userModel);
    }

    @GetMapping("/getUser")
    public List<UserModel> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public UserModel getUserByID(@PathVariable long id){
        return userService.getUserById(id);
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
