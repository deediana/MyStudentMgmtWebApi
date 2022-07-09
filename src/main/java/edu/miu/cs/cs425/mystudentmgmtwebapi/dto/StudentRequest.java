package edu.miu.cs.cs425.mystudentmgmtwebapi.dto;

import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Transcript;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class StudentRequest {
    @NotBlank(message = "Student name cannot be null, empty or blank")
    private Long studentNumber;

    private String name;

    private float cgpa;

    private LocalDate admissionDate;

    private Transcript transcript;

    public String getName() {
        return name;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }
}
