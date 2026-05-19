package com.pbi.tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pbi.tickets.model.CEstado;

public interface IEstadosRepository extends JpaRepository<CEstado, Integer>{

}
