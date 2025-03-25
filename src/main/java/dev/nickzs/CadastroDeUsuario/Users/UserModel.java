package dev.nickzs.CadastroDeUsuario.Users;

import dev.nickzs.CadastroDeUsuario.Assignments.AssignmentModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_user")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private int age;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 3")
    private int priority;

    @Column(name= "img_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private AssignmentModel assignment;


}


