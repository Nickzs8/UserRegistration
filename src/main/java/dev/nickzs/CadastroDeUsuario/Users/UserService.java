package dev.nickzs.CadastroDeUsuario.Users;

import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentModel;
import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private AssignmentRepository assignmentRepository;

    public UserService(UserRepository userRepository, AssignmentRepository assignmentRepository) {
        this.userRepository = userRepository;
        this.assignmentRepository = assignmentRepository;
    }

    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public UserModel getUserById(long id){
        Optional<UserModel> userModel = userRepository.findById(id);
        return userModel.orElse(null);
    }

    public String createUser(UserModel userModel){
        userRepository.save(userModel);
        return "User Created";
    }
    public void deleteUserById(long id){
        userRepository.deleteById(id);
    }

    public String updateUser(long id, UserModel updatedUser) {

        if(!userRepository.existsById(id)) return "User not found";

        Optional<UserModel> existingModel = userRepository.findById(id);
        UserModel userModel = existingModel.get();

        if (updatedUser.getName() != null) userModel.setName(updatedUser.getName());

        if (updatedUser.getEmail() != null) userModel.setEmail(updatedUser.getEmail());

        if (updatedUser.getAge() != 0) userModel.setAge(updatedUser.getAge());

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
