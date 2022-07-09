package edu.miu.cs.cs425.mystudentmgmtwebapi.service.impl;


import edu.miu.cs.cs425.mystudentmgmtwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.mystudentmgmtwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Student;
import edu.miu.cs.cs425.mystudentmgmtwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.mystudentmgmtwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addNewStudent(StudentRequest studentRequest) {
        var newStudent= Student.build(0, studentRequest.getStudentNumber(), studentRequest.getName(), studentRequest.getCgpa(), studentRequest.getAdmissionDate(), studentRequest.getTranscript());
        return newStudent;
    }


    @Override
    public List<Student> getAllStudents() {
        var students=studentRepository.findAll(Sort.by("name"));
        return students;
    }

    @Override
    public Student getStudentById(Long studentId) throws StudentNotFoundException {
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new StudentNotFoundException(String.format("Student with ID: %d is not found", studentId)));
    }

    @Override
    public List<Student> getPassingStudentsOnly() {
        return studentRepository.findStudentsWithCgpaGreaterThan3(3.0f);
    }

    @Override
    public List<Student> getLatestStudents() {
        return studentRepository.findStudentsByStudentNumberGreaterThan(980002);
    }

    @Override
    public Student updateStudent(Student updatedStudent) {
        return studentRepository.save(updatedStudent);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
