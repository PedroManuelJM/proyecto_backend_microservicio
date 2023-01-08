package com.proyecto.service.impl;
import com.proyecto.model.Enrollment;
import com.proyecto.repo.IEnrollmentRepo;
import com.proyecto.repo.IGenericRepo;
import com.proyecto.service.IEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EnrollmentServiceImpl extends  CrudImpl<Enrollment,Integer> implements IEnrollmentService {

    @Autowired
    private IEnrollmentRepo repo;
    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

}
