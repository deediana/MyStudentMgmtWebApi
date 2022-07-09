package edu.miu.cs.cs425.mystudentmgmtwebapi.service;

import edu.miu.cs.cs425.mystudentmgmtwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.mystudentmgmtwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Student;

import java.util.List;

public interface StudentService {
    //static void saveStudent(Student student) {
    //}

    Student addNewStudent(StudentRequest studentRequest);

    List<Student> getAllStudents();

    Student getStudentById(Long studentId) throws StudentNotFoundException;
    //Student save(Student s);
    List<Student> getPassingStudentsOnly();
    List<Student> getLatestStudents();
    Student updateStudent(Student updatedStudent);
    //void updateStudent(Classroom classroom, long studentId);

    void deleteStudentById(Long studentId);
}
