package com.proyecto.service.impl;

import com.proyecto.model.Student;
import com.proyecto.repo.IGenericRepo;
import com.proyecto.repo.IStudentRepo;
import com.proyecto.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl extends  CrudImpl<Student,Integer> implements IStudentService {

    @Autowired
    private IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> report() {

        Comparator<Student> inverse=(x1,x2) -> x2.getAge()-x1.getAge();
        return  repo.findAll().stream().sorted(inverse).collect(Collectors.toList());

    }


}
