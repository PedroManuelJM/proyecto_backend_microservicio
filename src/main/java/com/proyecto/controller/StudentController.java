package com.proyecto.controller;

import com.proyecto.dto.StudentDTO;
import com.proyecto.exception.ModelNotFoundException;
import com.proyecto.model.Student;
import com.proyecto.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private IStudentService service;

    @Autowired
    @Qualifier("studentMapper")
    private ModelMapper mapper;
    @GetMapping

    public ResponseEntity<List<StudentDTO>> readAll() throws Exception{
        List<StudentDTO> list =service.readAll().stream().map(student -> mapper.map(student,StudentDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception{

        StudentDTO obj=mapper.map(service.readById(id),StudentDTO.class);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+ id);
        }
        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) throws Exception{
       // return service.save(student);
        Student obj=service.save(mapper.map(dto,Student.class));
        return new ResponseEntity<>(mapper.map(obj,StudentDTO.class),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<StudentDTO> update(@Valid @RequestBody StudentDTO dto) throws Exception{

        Student obj=service.update(mapper.map(dto,Student.class));
        return new ResponseEntity<>(mapper.map(obj,StudentDTO.class),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Student obj=service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+ id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   // Listar estudiantes ordenados de forma descendente por edad
    @GetMapping("/report")
    public ResponseEntity<List<StudentDTO>> reportstudentage(){
        List<StudentDTO> list =service.report().stream().map(student -> mapper.map(student,StudentDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>( list,HttpStatus.OK);
    }


}
