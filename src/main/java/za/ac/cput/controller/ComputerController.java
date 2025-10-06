package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Computer;
import za.ac.cput.service.ComputerService;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping("/api")
public class ComputerController {

    private final ComputerService computerService;

    @Autowired
    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    // Get all computers by faculty
    @GetMapping("/SearchComputer/{faculty}")
    public ResponseEntity<?> searchComputersByFaculty(@PathVariable String faculty) {
        try {
            List<Computer> computers = computerService.searchByFaculty(faculty);

            if (computers.isEmpty()) {
                return ResponseEntity.badRequest().body("No computers found for faculty: " + faculty);
            }

            return ResponseEntity.ok(computers);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
