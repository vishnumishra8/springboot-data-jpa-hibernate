package com.hibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(indexes = {
        @Index(name="idx_Dr_Id",columnList = "id")
})
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String specialization;
    @Column(unique=true,nullable=false)
    private String email;
    @CreationTimestamp
    @Column(updatable=false)
    private LocalDate joiningDate;

    @ManyToMany(mappedBy="doctors")
    private Set<Department> departments = new HashSet<Department>();
    @OneToOne(mappedBy = "headDoctor")
    private Department department;


}
