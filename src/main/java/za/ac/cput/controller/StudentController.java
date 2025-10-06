package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Student;
import za.ac.cput.service.StudentService;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Register student
    @PostMapping("/SignUp")
    public ResponseEntity<?> registerStudent(@RequestBody Student student) {
        try {
            Student registeredStudent = studentService.create(student);
            return ResponseEntity.ok(Map.of("student", registeredStudent));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    // Login student
    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        try {
            Student student = studentService.validateUserLogIn(email, password);
            return ResponseEntity.ok(Map.of(
                    "studentId", student.getStudentId(),
                    "firstName", student.getFirstName(),
                    "lastName", student.getLastName(),
                    "faculty", student.getFaculty(),
                    "enrollmentYear", student.getEnrollmentYear(),
                    "currentYear", student.getCurrentYear(),
                    "email", student.getEmail()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}
