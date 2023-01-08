package com.proyecto.controller;

import com.proyecto.dto.CourseDTO;
import com.proyecto.exception.ModelNotFoundException;
import com.proyecto.model.Course;
import com.proyecto.model.Student;
import com.proyecto.service.ICourseService;
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
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private ICourseService service;
    @Autowired
    @Qualifier("courseMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>>readAll() throws Exception{

        List<CourseDTO> list =service.readAll().stream().map(course -> mapper.map(course,CourseDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO>readById(@PathVariable("id") Integer id) throws Exception{

        CourseDTO obj= mapper.map(service.readById(id),CourseDTO.class);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+ id);
        }

        return new ResponseEntity<>(obj,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj=service.save(mapper.map(dto,Course.class));
        return new ResponseEntity<>(mapper.map(obj,CourseDTO.class),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CourseDTO> update(@Valid @RequestBody CourseDTO dto) throws Exception{

        Course obj=service.update(mapper.map(dto,Course.class));
        return new ResponseEntity<>(mapper.map(obj,CourseDTO.class),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Course obj=service.readById(id);
        if(obj == null){
            throw new ModelNotFoundException("ID NOT FOUND: "+ id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
