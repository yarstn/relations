package com.example.school.Controller;

import com.example.school.DTO.AddressDTO;
import com.example.school.Model.Teacher;
import com.example.school.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity getProfile() {
        return ResponseEntity.ok(addressService.getProfile());
    }
    @PostMapping("/add")
    public ResponseEntity addProfile(@Valid @RequestBody AddressDTO profile) {
        addressService.addProfile(profile);
        return ResponseEntity.ok("address added successfully");

    }
    @PutMapping("/update")
    public ResponseEntity updateProfile(@Valid @RequestBody AddressDTO profile) {
        addressService.updateProfile(profile);
        return ResponseEntity.ok("address updated successfully");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProfile(@PathVariable int id) {
        addressService.deleteProfile(id);
        return ResponseEntity.ok("address deleted successfully");
    }
    @GetMapping("/{teacherId}")
    public ResponseEntity getTeacherDetails(@PathVariable Integer teacherId) {
        Teacher teacher = addressService.getTeacherDetails(teacherId);
        return ResponseEntity.ok(teacher);
    }
}
