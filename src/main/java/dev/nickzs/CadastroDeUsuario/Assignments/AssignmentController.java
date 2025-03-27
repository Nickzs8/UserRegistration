package dev.nickzs.CadastroDeUsuario.Assignments;
import dev.nickzs.CadastroDeUsuario.Users.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/createAssignment")
    public String addAssignment(@RequestBody AssignmentDTO assignmentDTO){
        return assignmentService.createAssignment(assignmentDTO);
    }

    @GetMapping("/getAssignment")
    public List<AssignmentDTO> getAllAssignments(){
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/getAssignment/{id}")
    public AssignmentDTO getAssignmentByID(@PathVariable long id){
        return assignmentService.getAssignmentByID(id);
    }

    @PatchMapping("/update/{id}")
    public String updateAssignment(@PathVariable long id, @RequestBody AssignmentDTO updatedAssignment){
        return assignmentService.updateAssignment(id, updatedAssignment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssignment(@PathVariable long id){
        assignmentService.deleteAssignment(id);
    }
}
