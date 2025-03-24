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
    public String addAssignment(@RequestBody AssignmentModel assignmentModel){
        return assignmentService.createAssignment(assignmentModel);
    }

    @GetMapping("/getAssignment")
    public List<AssignmentModel> getAllAssignments(){
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/getAssignment/{id}")
    public AssignmentModel getAssignmentByID(@PathVariable long id){
        return assignmentService.getAssignmentByID(id);
    }

    @PutMapping("/update/{id}")
    public String updateAssignment(@PathVariable long id, @RequestBody AssignmentModel updatedAssignment){
        return assignmentService.updateAssignment(id, updatedAssignment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssignment(@PathVariable long id){
        assignmentService.deleteAssignment(id);
    }
}
