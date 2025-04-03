package dev.nickzs.CadastroDeUsuario.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users/ui")
public class UserControlerUI {
    private final UserService userService;

    public UserControlerUI(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public String getAllUsers(Model model){
        List<UserDTO> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "getUser";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
        return "redirect:/users/ui/getUser";
    }

    @GetMapping("/getUser/{id}")
    public String getUserByID(@PathVariable long id, Model model){
        UserDTO userDTO = userService.getUserById(id);

        if(userDTO != null){
            model.addAttribute("user", userDTO);
            return "detailsUser";
        } else
            model.addAttribute("message", "User not found");

            return "getUser";
    }

    @PostMapping("/createUser")
    public String addUser(@ModelAttribute UserDTO userDTO){
        userService.createUser(userDTO);
        return "redirect:/users/ui/getUser";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registerUser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable long id, @ModelAttribute UserDTO updatedUser){
            userService.updateUser(id, updatedUser);
            return "redirect:/users/ui/getUser";
    }

    @PostMapping("/updateUser")
    public String showUpdateForm(@RequestParam("id") long id, Model model) {
        UserDTO userDTO = userService.getUserById(id);
        model.addAttribute("user", userDTO);
        return "updateUser";
    }



}
