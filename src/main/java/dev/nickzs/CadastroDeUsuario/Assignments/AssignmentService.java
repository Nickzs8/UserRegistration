package dev.nickzs.CadastroDeUsuario.Assignments;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<AssignmentModel> getAllAssignments(){
        return assignmentRepository.findAll();
    }

    public AssignmentModel getAssignmentByID(long id){
        Optional<AssignmentModel> assignmentModel = assignmentRepository.findById(id);
        return assignmentModel.orElse(null);
    }

    public void deleteAssignment(long id){
        assignmentRepository.deleteById(id);
    }
}
