package com.example.prueba.peticion;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeticionService {
    private final PeticionRepository repository;

    public void insrtertar(Peticion peticion) {
        repository.save(peticion);
    }

    public List<Peticion> getAllLogs() {
        return repository.findAll();
    }
}
