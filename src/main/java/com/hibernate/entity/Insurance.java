package com.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Setter(AccessLevel.NONE)
@Getter
@Entity
@Table(name="Insurance")
public class Insurance {
    @Id
    private long id;
    @Column(unique = true,nullable = false,length = 80)
    private String policyNumber;
    @Column(nullable = false,length = 80)
    private String ProviderCompany;
    @Column(nullable = false)
    private LocalDate valitTo;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate creationDate;

   @OneToOne
   @JoinColumn(name="patient")
    private Patient patient;
}
