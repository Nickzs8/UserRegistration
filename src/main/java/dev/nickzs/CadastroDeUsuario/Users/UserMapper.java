package dev.nickzs.CadastroDeUsuario.Users;

import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentDTO;
import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentMapper;
import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final AssignmentMapper assignmentMapper;

    public UserMapper(AssignmentMapper assignmentMapper) {
        this.assignmentMapper = assignmentMapper;
    }

    public UserModel mapToModel(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setEmail(userDTO.getEmail());
        userModel.setAge(userDTO.getAge());
        userModel.setPriority(userDTO.getPriority() != 0 ? userDTO.getPriority() : 3);
        userModel.setImageUrl(userDTO.getImageUrl());

        if (userDTO.getAssignment() != null) {
            userModel.setAssignment(assignmentMapper.mapToModel(userDTO.getAssignment()));
        }

        return userModel;
    }

    public UserDTO mapToDTO(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setEmail(userModel.getEmail());
        userDTO.setAge(userModel.getAge());
        userDTO.setPriority(userModel.getPriority());
        userDTO.setImageUrl(userModel.getImageUrl());

        if (userModel.getAssignment() != null) {
            userDTO.setAssignment(assignmentMapper.mapToDTO(userModel.getAssignment()));
        }

        return userDTO;
    }
}
