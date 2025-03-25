package dev.nickzs.CadastroDeUsuario.Users;

import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentDTO;
import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private int age;
    private AssignmentDTO assignment;
    private int priority;
    private String imageUrl;

}
