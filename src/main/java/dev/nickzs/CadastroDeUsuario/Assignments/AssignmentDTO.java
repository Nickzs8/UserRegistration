package dev.nickzs.CadastroDeUsuario.Assignments;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.nickzs.CadastroDeUsuario.Users.UserDTO;
import dev.nickzs.CadastroDeUsuario.Users.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AssignmentDTO {
    private long id;
    private String name;
    private int hoursToCompletion;
    @JsonIgnore
    private List<UserDTO> users;
}
