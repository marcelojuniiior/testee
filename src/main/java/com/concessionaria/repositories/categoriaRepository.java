package com.concessionaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionaria.entities.Categoria;

public interface categoriaRepository extends JpaRepository<Categoria, Long> {
    
}
