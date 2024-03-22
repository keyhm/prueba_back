package com.alianza.springboot.prueba.tecnica.models.services;

import com.alianza.springboot.prueba.tecnica.models.entity.Cliente;

import java.util.List;

public interface IClienteService  {

    List<Cliente> findAll();
    Cliente findBySharedKey(String shared_key);
    Cliente createNewClient(Cliente cliente);

}
