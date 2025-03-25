package dev.nickzs.CadastroDeUsuario.Assignments;

import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {
    public AssignmentDTO mapToDTO(AssignmentModel assignmentModel) {
        AssignmentDTO assignmentDTO = new AssignmentDTO();
        assignmentDTO.setId(assignmentModel.getId());
        assignmentDTO.setName(assignmentModel.getName());
        assignmentDTO.setHoursToCompletion(assignmentModel.getHoursToCompletion());

        return assignmentDTO;
    }

    public AssignmentModel mapToModel(AssignmentDTO assignmentDTO) {
        AssignmentModel assignmentModel = new AssignmentModel();
        assignmentModel.setId(assignmentDTO.getId());
        assignmentModel.setName(assignmentDTO.getName());
        assignmentModel.setHoursToCompletion(assignmentDTO.getHoursToCompletion());

        return assignmentModel;
    }

}
