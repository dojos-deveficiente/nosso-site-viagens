package com.example.demo.rota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Long> {

	boolean existsByAirportOrigem_Id_AndAirportDestino_Id(Long origemId, Long destinoId);

}
