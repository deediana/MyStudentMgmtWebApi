package edu.miu.cs.cs425.mystudentmgmtwebapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="transcripts")
public class Transcript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transcript_id")
    private Long transcriptId;

    @Column(name="degree_title")
    private String degreeTitle;

    @OneToOne(mappedBy = "transcript", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Student student;

    public Transcript() {
    }

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Transcript(String degreeTitle, Student student) {
        this.degreeTitle = degreeTitle;
        this.student = student;
    }

    public Transcript(Long transcriptId, String degreeTitle, Student student) {
        this.transcriptId = transcriptId;
        this.degreeTitle = degreeTitle;
        this.student = student;
    }

    public Long getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(Long transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public Student getStudent() {

        return student;
    }

    public void setStudent(Student student) {

        this.student = student;
    }
    @Override
    public String toString() {
        return  degreeTitle;
    }
//    @Override
//    public String toString(){
//        return String.format("%s<br>%s %s %s %s", transcriptId,degreeTitle);
//    }
}
