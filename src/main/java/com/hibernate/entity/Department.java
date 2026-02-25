package com.hibernate.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {
    @Id
    private int id;

    @Column(nullable=false)
    private String name;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @OneToOne
    @JoinColumn(nullable=false)
    private Doctor headDoctor;
    @ManyToMany
    @JoinTable(
            name="dpt_doctor_table",
            joinColumns = @JoinColumn(name="dpt_id"),
            inverseJoinColumns = @JoinColumn(name="dr_id")
    )
    private Set<Doctor> doctors= new HashSet<Doctor>();
}
