package com.hibernate.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private String email;
    private String bloodGroup;
    private LocalDate createdAt;

}
