package com.proyecto.service.impl;

import com.proyecto.model.Course;
import com.proyecto.repo.ICourseRepo;
import com.proyecto.repo.IGenericRepo;
import com.proyecto.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseServiceImpl extends  CrudImpl<Course,Integer> implements ICourseService {

    @Autowired
    private ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }


}
