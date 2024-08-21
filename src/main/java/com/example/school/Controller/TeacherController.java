package com.example.school.Controller;

import com.example.school.Model.Teacher;
import com.example.school.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/teach")
@RestController //json
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getCustomer() {
        return ResponseEntity.status(200).body(teacherService.getAllCustomers());
    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@Valid @RequestBody Teacher teacher) {
        teacherService.addCustomer(teacher);
        return ResponseEntity.status(200).body("teach added");
    }

    @PutMapping("/upadte/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id, @Valid @RequestBody Teacher teacher) {
        teacherService.updateCustomer(id, teacher);
        return ResponseEntity.status(200).body("teach updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        teacherService.deleteCustomer(id);
        return ResponseEntity.status(200).body("teach deleted");
    }

}
