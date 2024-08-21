package com.example.school.Repository;

import com.example.school.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher,Integer> {
    Teacher findByid(Integer id);
}
