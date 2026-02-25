package com.hibernate.entity;

import com.hibernate.entity.enums.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter
@Builder
@Entity
@Table(name ="Patient",
        uniqueConstraints={
        @UniqueConstraint(columnNames = {"email"})
        },
        indexes = {
        @Index(name="idx_birthDate_bloodGroup_createdAt" ,columnList = "birthDate,bloodGroup,createdAt,")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Patient_Name", nullable = false, length = 50)
    private String name;

    private String gender;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDate createdAt;

    @OneToOne(mappedBy = "patient")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointment = new HashSet<Appointment>();

}
