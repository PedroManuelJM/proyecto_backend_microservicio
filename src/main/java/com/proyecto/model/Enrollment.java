package com.proyecto.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity

public class Enrollment {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnrollment; // idmatricula

    @Column(nullable = false)
    private LocalDateTime datetime; // fecha matricula

    @ManyToOne // SE ENLAZA CON LA CLASE ESTUDIANTE
    @JoinColumn(name = "idStudent",nullable = false , foreignKey =@ForeignKey(name="FK_Enrollment_Student"))
    private Student student; // CLASE ESTUDIANTE

    @Column(nullable = false)
    private boolean status; // estado

    @OneToMany(mappedBy = "enrollment" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<EnrollmentDetail> details;



}
