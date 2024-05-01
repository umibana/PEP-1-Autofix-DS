package com.example.autofix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.autofix.entities.ReparacionEntity;

@Repository
public interface ReparacionRepository extends JpaRepository<ReparacionEntity, Long>{
    
}
