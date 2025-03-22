package dev.nickzs.CadastroDeUsuario.Assingments;

import dev.nickzs.CadastroDeUsuario.Users.UserModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_assignment")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class AssingmentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private int hoursToCompletion;

    @Column
    @OneToMany(mappedBy = "assignment")
    private List<UserModel> users;
}
