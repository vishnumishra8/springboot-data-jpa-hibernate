package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Setter
@Getter
@Entity
@Table(name="Appointment",
indexes = {
        @Index(name="idx_appointment_id",columnList = "id")
})
public class Appointment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private LocalDate appointmentTime;

    @Column(nullable=false)
    private String probleml;

    private String status;

    @ManyToOne
    @JoinColumn(name="doctor",nullable=false)
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name="patient",nullable=false)
    private Patient patient;

}
