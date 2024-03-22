package com.alianza.springboot.prueba.tecnica.models.dao;

import com.alianza.springboot.prueba.tecnica.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDao extends JpaRepository<Cliente, String> {

}
