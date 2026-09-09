package com.ipn.tickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipn.tickets.model.CEstado;

public interface IEstadosRepository extends JpaRepository<CEstado, Integer>{

}
