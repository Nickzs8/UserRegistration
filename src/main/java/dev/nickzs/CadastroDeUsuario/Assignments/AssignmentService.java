package dev.nickzs.CadastroDeUsuario.Assignments;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<AssignmentModel> getAllAssignments(){
        return assignmentRepository.findAll();
    }
}
