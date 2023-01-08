package com.proyecto.service;

import com.proyecto.model.Student;

import java.util.List;


public interface IStudentService extends ICRUD<Student,Integer>{

    List <Student> report();

}
