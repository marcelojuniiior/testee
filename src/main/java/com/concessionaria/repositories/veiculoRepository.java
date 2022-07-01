package com.concessionaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.concessionaria.entities.Veiculo;

public interface veiculoRepository extends JpaRepository<Veiculo, Long>{
    
}
