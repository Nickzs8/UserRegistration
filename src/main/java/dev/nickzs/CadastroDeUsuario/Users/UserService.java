package dev.nickzs.CadastroDeUsuario.Users;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }
}
