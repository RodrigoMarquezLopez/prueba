package com.example.prueba.peticion;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "peticion_logs")
@Builder
public class Peticion {
    @Id
    @GeneratedValue
    private Long id;
    private String ip;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

}
