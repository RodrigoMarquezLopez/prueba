package com.example.prueba.peticion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeticionRepository extends JpaRepository<Peticion, Long> {

}
