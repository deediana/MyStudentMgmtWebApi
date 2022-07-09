package edu.miu.cs.cs425.mystudentmgmtwebapi.controller.restapi.v1;

import edu.miu.cs.cs425.mystudentmgmtwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Student;
import edu.miu.cs.cs425.mystudentmgmtwebapi.service.StudentService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value={"/e-registrar/api/v1/student"})
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value={"/list"})
    public ResponseEntity<List<Student>> ListStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping(value={"/get/{studentId}"})
    public ResponseEntity<Student> getStudentId(@PathVariable Long studentId) throws StudentNotFoundException {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    public ResponseEntity<Student> addNewStudent(@PathVariable Student student){
        return null;
        //return ResponseEntity.ok(studentService.addNewStudent(student));
    }


}
