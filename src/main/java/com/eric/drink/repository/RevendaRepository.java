package com.eric.drink.repository;

import com.eric.drink.models.Revenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RevendaRepository extends JpaRepository<Revenda, UUID> {

}
