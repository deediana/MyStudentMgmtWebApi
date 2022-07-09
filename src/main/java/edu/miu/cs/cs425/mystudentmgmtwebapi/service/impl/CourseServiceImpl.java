package edu.miu.cs.cs425.mystudentmgmtwebapi.service.impl;

import edu.miu.cs.cs425.mystudentmgmtwebapi.model.Course;
import edu.miu.cs.cs425.mystudentmgmtwebapi.repository.CourseRepository;
import edu.miu.cs.cs425.mystudentmgmtwebapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
