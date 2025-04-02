package dev.nickzs.CadastroDeUsuario.Assignments;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.nickzs.CadastroDeUsuario.Users.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_assignment")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class AssignmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private int hoursToCompletion;

    @Column
    @OneToMany(mappedBy = "assignment")
    @JsonIgnore
    private List<UserModel> users;
}
