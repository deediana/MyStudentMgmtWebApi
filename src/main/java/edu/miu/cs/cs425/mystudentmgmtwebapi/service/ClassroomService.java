package edu.miu.cs.cs425.mystudentmgmtwebapi.service;


import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Classroom;

public interface ClassroomService {
    Classroom save(Classroom cr);
    Classroom getClassroomById(int id);
}
