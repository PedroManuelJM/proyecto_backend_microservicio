package com.proyecto.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.proyecto.model.Course;
import com.proyecto.model.Enrollment;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EnrollmentDetailDTO {


    @JsonBackReference
    private EnrollmentDTO enrollment;

    @NotNull
    private CourseDTO course;

    @NotNull
    private String classroom;

}
