package com.example.school.Service;

import com.example.school.Api.ApiException;
import com.example.school.Model.Teacher;
import com.example.school.Repository.TeacherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepo teacherRepo;
//get
    public List<Teacher> getAllCustomers() {
        return teacherRepo.findAll();
    }
    //add
    public void addCustomer(Teacher teacher) {
       teacherRepo.save(teacher);
    }
    //update
    public void updateCustomer(Integer id, Teacher teacher) {
        Teacher teacher1 = teacherRepo.findByid(id);
        if (teacher1 == null) {
            throw new ApiException("teach not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepo.save(teacher1);
    }
    public void deleteCustomer(Integer id) {
        Teacher teacher = teacherRepo.findByid(id);
        if (teacher == null) {
            throw new ApiException("teach not found");
        }
        teacherRepo.delete(teacher);
    }
}
