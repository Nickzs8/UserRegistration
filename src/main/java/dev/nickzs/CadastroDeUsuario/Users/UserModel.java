package dev.nickzs.CadastroDeUsuario.Users;

import dev.nickzs.CadastroDeUsuario.Assingments.AssingmentModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data

public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private int age;

    @ManyToOne
    @JoinColumn(name = "assingment_id")
    private AssingmentModel assingment;


}

