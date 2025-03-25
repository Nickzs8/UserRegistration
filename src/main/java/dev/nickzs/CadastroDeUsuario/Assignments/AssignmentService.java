package dev.nickzs.CadastroDeUsuario.Assignments;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {

    private final AssignmentMapper assignmentMapper;
    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository, AssignmentMapper assignmentMapper) {
        this.assignmentRepository = assignmentRepository;
        this.assignmentMapper = assignmentMapper;
    }

    public String createAssignment(AssignmentDTO assignmentDTO){
        AssignmentModel assignmentModel = assignmentMapper.mapToModel(assignmentDTO);
         assignmentRepository.save(assignmentModel);
         return "Assignment Created";
    }

    public List<AssignmentModel> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public AssignmentModel getAssignmentByID(long id) {
        Optional<AssignmentModel> assignmentModel = assignmentRepository.findById(id);
        return assignmentModel.orElse(null);
    }

    public void deleteAssignment(long id) {
        assignmentRepository.deleteById(id);
    }

    public String updateAssignment(long id, AssignmentDTO updatedAssignment) {

        if (!assignmentRepository.existsById(id)) return "Assignment not found";

        Optional<AssignmentModel> existingModel = assignmentRepository.findById(id);
        AssignmentModel assignmentModel = existingModel.get();

        if (updatedAssignment.getName() != null) assignmentModel.setName(updatedAssignment.getName());


        if (updatedAssignment.getHoursToCompletion() != 0)
            assignmentModel.setHoursToCompletion(updatedAssignment.getHoursToCompletion());

        assignmentRepository.save(assignmentModel);
        return "Assignment Updated";
    }
}
