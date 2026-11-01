package com.tt.internship;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class InternshipApplicationController {

    private final InternshipApplicationRepository repository;

    public InternshipApplicationController(InternshipApplicationRepository repository) {
        this.repository = repository;
    }

    // 1. View all applications
    @GetMapping
    public List<InternshipApplication> getAllApplications() {
        return repository.findAllByOrderByIdDesc();
    }

    // 2. View single application by ID
    @GetMapping("/{id}")
    public ResponseEntity<InternshipApplication> getApplicationById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Add student internship application
    @PostMapping
    public ResponseEntity<InternshipApplication> createApplication(@Valid @RequestBody InternshipApplication application) {
        application.setId(null);
        InternshipApplication saved = repository.save(application);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // 4. Update application details or status
    @PutMapping("/{id}")
    public ResponseEntity<InternshipApplication> updateApplication(
            @PathVariable Long id,
            @Valid @RequestBody InternshipApplication updated) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setStudentName(updated.getStudentName());
                    existing.setRollNumber(updated.getRollNumber());
                    existing.setCompanyName(updated.getCompanyName());
                    existing.setStatus(updated.getStatus());
                    InternshipApplication saved = repository.save(existing);
                    return ResponseEntity.ok(saved);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // 5. Delete an application
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteApplication(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Application deleted successfully");
        return ResponseEntity.ok(response);
    }

    // Handle validation errors with user-friendly error messages
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> response = new HashMap<>();
        String errorMessage = "Validation failed";
        FieldError fieldError = ex.getBindingResult().getFieldError();
        if (fieldError != null && fieldError.getDefaultMessage() != null) {
            errorMessage = fieldError.getDefaultMessage();
        }
        response.put("error", errorMessage);
        response.put("message", errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
