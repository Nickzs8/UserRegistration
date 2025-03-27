package dev.nickzs.CadastroDeUsuario.Assignments;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<AssignmentDTO> getAllAssignments() {
        List<AssignmentModel> assignments = assignmentRepository.findAll();
        return assignments.stream()
                .map(assignmentMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    public AssignmentDTO getAssignmentById(long id) {
        Optional<AssignmentModel> assignmentModel = assignmentRepository.findById(id);
        return assignmentModel.map(assignmentMapper::mapToDTO).orElse(null);
    }

    public void deleteAssignmentById(long id) {
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
