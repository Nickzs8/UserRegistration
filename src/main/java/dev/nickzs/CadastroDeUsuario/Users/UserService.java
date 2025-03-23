package dev.nickzs.CadastroDeUsuario.Users;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public UserModel getUserById(long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.orElse(null);
    }

    public UserModel createUser(UserModel userModel){
        return userRepository.save(userModel);
    }
}
