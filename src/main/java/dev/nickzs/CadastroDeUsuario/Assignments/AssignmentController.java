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

    @GetMapping("/allAssignments")
    public List<AssignmentModel> getAllAssignments(){
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/allID")
    public String getassignmentByID(){
        return "";
    }

    @PutMapping("/update")
    public String updateAssignment(){
        return "";
    }

    @DeleteMapping("/delete")
    public String deleteAssignment(){
        return "";
    }
}
