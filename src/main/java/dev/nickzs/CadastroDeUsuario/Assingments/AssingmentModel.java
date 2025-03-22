package dev.nickzs.CadastroDeUsuario.Assingments;

import dev.nickzs.CadastroDeUsuario.Users.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_assingments")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data

public class AssingmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int hoursToCompletion;

    @OneToMany(mappedBy = "assignment")
    private List<UserModel> users;
}
