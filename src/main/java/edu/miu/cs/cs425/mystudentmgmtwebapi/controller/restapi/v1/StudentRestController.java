package edu.miu.cs.cs425.mystudentmgmtwebapi.controller.restapi.v1;

import edu.miu.cs.cs425.mystudentmgmtwebapi.dto.StudentRequest;
import edu.miu.cs.cs425.mystudentmgmtwebapi.exception.StudentNotFoundException;
import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Student;
import edu.miu.cs.cs425.mystudentmgmtwebapi.service.StudentService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping(value={"/new"})
    public ResponseEntity<Student> addNewStudent(@Valid @RequestBody StudentRequest studentRequest){
        return new ResponseEntity<>(studentService.addNewStudent(studentRequest),
                HttpStatus.CREATED);

    }

    @PutMapping(value={"/update/{studentId}"})
    public ResponseEntity<Student> updateStudent(@Valid @RequestBody StudentRequest studentRequest, @PathVariable Long studentId){
        return new ResponseEntity<>(studentService.updateStudent(studentRequest,studentId),
                HttpStatus.OK);
    }

    @DeleteMapping(value={"/delete/{studentId}"})
    public ResponseEntity.BodyBuilder deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK);
    }

}
