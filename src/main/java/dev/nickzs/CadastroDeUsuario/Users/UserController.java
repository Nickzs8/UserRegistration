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

    @PostMapping("/createUser")
    public String addUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @GetMapping("/getUser")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getUser/{id}")
    public UserDTO getUserByID(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PatchMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody UserDTO updatedUser){
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
    }


}
