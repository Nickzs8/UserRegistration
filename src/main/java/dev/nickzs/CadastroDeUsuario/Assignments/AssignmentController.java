package dev.nickzs.CadastroDeUsuario.Assignments;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    private AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/Greetings")
    public String Greetings(){
        return "This is my first message in this route.";
    }

    @PostMapping("/add")
    public String addAssignment(){
        return "assingment added";
    }

    @GetMapping("/getAssignment")
    public List<AssignmentModel> getAllAssignments(){
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/getAssignment/{id}")
    public AssignmentModel getAssignmentByID(@PathVariable long id){
        return assignmentService.getAssignmentByID(id);
    }

    @PutMapping("/update")
    public String updateAssignment(){
        return "";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssignment(@PathVariable long id){
        assignmentService.deleteAssignment(id);
    }
}
