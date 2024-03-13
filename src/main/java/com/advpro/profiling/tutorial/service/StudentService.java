package com.advpro.profiling.tutorial.service;

import com.advpro.profiling.tutorial.model.Student;
import com.advpro.profiling.tutorial.model.StudentCourse;
import com.advpro.profiling.tutorial.repository.StudentCourseRepository;
import com.advpro.profiling.tutorial.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.StringJoiner;
/**
 * @author muhammad.khadafi
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public List<StudentCourse> getAllStudentsWithCourses() {
        List<StudentCourse> studentCourses = new ArrayList<>();
        List<StudentCourse> allStudentCourses = studentCourseRepository.findAll();
        Map<Long, List<StudentCourse>> studentCourseMap = new HashMap<>();
        for (StudentCourse studentCourse : allStudentCourses) {
            Long studentId = studentCourse.getStudent().getId();
            studentCourseMap.computeIfAbsent(studentId, k -> new ArrayList<>()).add(studentCourse);
        }
        for (Student student : studentRepository.findAll()) {
            List<StudentCourse> coursesForStudent = studentCourseMap.getOrDefault(student.getId(), new ArrayList<>());
            studentCourses.addAll(coursesForStudent);
        }

        return studentCourses;
    }

    public Optional<Student> findStudentWithHighestGpa() {
        return studentRepository.findAll().stream()
                .max(Comparator.comparingDouble(Student::getGpa));
    }

    public String joinStudentNames() {
        List<Student> students = studentRepository.findAll();
        StringJoiner joiner = new StringJoiner(", ");
        for (Student student : students) {
            joiner.add(student.getName());
        }
        return joiner.toString();
    }
}

