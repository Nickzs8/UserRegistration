package dev.nickzs.CadastroDeUsuario.Users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created sucessfully!" + userDTO.getName() + " (ID):" + userDTO.getId());

    }

    @GetMapping("/getUser")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<?> getUserByID(@PathVariable long id){
        UserDTO userDTO = userService.getUserById(id);
        if(userDTO != null){
            return ResponseEntity.ok(userDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + "was not found!");
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UserDTO updatedUser){
        if(userService.getUserById(id) != null) {
            userService.updateUser(id, updatedUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + "was not found!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){

        if(userService.getUserById(id) != null){
            userService.deleteUserById(id);
            return ResponseEntity.ok("User with ID " + id + "deleted with sucess!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User with ID " + id + "was not found!");
        }


    }


}
