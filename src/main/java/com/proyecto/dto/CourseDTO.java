package com.proyecto.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {


    private Integer idCourse;

    @NotNull
    @NotEmpty
    @Size(min= 4 , max=72)
    private String nameCourse;

    @NotNull
    @NotEmpty
    @Size(min= 3 , max=12)
    private String initialCourse;

    @NotNull
    private boolean statusCourse;


}

