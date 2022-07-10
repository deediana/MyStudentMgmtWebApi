package edu.miu.cs.cs425.mystudentmgmtwebapi.dto;


import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Classroom;
import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Course;
import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Transcript;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class StudentRequest {


    private Long studentNumber;

    private String name;

    private Float cgpa;

    private LocalDate admissionDate;

    private Transcript transcript;

    private Classroom classroom;

    private List<Course> courses;

}
