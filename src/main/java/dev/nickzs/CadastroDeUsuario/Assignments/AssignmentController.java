package dev.nickzs.CadastroDeUsuario.Assignments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @PostMapping("/createAssignment")
    public ResponseEntity<String> addAssignment(@RequestBody AssignmentDTO assignmentDTO){
        assignmentService.createAssignment(assignmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("assignment created sucessfully!" + assignmentDTO.getName() + " (ID):" + assignmentDTO.getId());
    }

    @GetMapping("/getAssignment")
    public ResponseEntity<List<AssignmentDTO>> getAllAssignments(){
        List<AssignmentDTO> assignments = assignmentService.getAllAssignments();
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("/getAssignment/{id}")
    public ResponseEntity<?> getAssignmentByID(@PathVariable long id){
        AssignmentDTO assignmentDTO = assignmentService.getAssignmentById(id);
        if(assignmentDTO != null){
            return ResponseEntity.ok(assignmentDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Assignment with ID " + id + "was not found!");
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateAssignment(@PathVariable long id, @RequestBody AssignmentDTO updatedAssignment){
        if(assignmentService.getAssignmentById(id) != null) {
            assignmentService.updateAssignment(id, updatedAssignment);
            return ResponseEntity.ok(updatedAssignment);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Assignment with ID " + id + "was not found!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAssignment(@PathVariable long id){

        if(assignmentService.getAssignmentById(id) != null){
            assignmentService.deleteAssignmentById(id);
            return ResponseEntity.ok("assignment with ID " + id + "deleted with sucess!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("assignment with ID " + id + "was not found!");
        }
    }
}
