package dev.nickzs.CadastroDeUsuario.Users;

import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentModel;
import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, AssignmentRepository assignmentRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.assignmentRepository = assignmentRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> getAllUsers(){
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO getUserById(long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.map(userMapper::mapToDTO).orElse(null);
    }

    public UserDTO createUser(UserDTO userDTO){
        UserModel userModel = userMapper.mapToModel(userDTO);
        userRepository.save(userModel);
        return userDTO;
    }
    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }

    public String updateUser(long id, UserDTO updatedUser) {

        if(!userRepository.existsById(id)) return "User not found";

        Optional<UserModel> existingModel = userRepository.findById(id);
        UserModel userModel = existingModel.get();

        if (updatedUser.getName() != null) userModel.setName(updatedUser.getName());

        if (updatedUser.getEmail() != null) userModel.setEmail(updatedUser.getEmail());

        if (updatedUser.getAge() != 0) userModel.setAge(updatedUser.getAge());

        if(updatedUser.getPriority() != 0) userModel.setPriority(updatedUser.getPriority());

        if(updatedUser.getImageUrl() != null) userModel.setImageUrl(updatedUser.getImageUrl());

        if (updatedUser.getAssignment() != null && updatedUser.getAssignment().getId() != 0) {
            Optional<AssignmentModel> existingAssignment =
                    assignmentRepository.findById(updatedUser.getAssignment().getId());
            if (existingAssignment.isPresent()) userModel.setAssignment(existingAssignment.get());
            else throw new RuntimeException
                    ("Assignment not found with id: " + updatedUser.getAssignment().getId());
        }

        userRepository.save(userModel);
        return "User updated";
    }
}
