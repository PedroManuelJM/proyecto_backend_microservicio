package com.proyecto.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.proyecto.model.EnrollmentDetail;
import com.proyecto.model.Student;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EnrollmentDTO {


    private Integer idEnrollment; // idmatricula

    @NotNull
    private LocalDateTime datetime; // fecha matricula


    @NotNull
    private StudentDTO student; // CLASE ESTUDIANTE


    @NotNull
    private boolean status; // estado


    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;


}
