package dev.nickzs.CadastroDeUsuario.Users;

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

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody UserModel updatedUser){
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
    }


}
