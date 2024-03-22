package com.alianza.springboot.prueba.tecnica.models.services;

import com.alianza.springboot.prueba.tecnica.models.dao.IClienteDao;
import com.alianza.springboot.prueba.tecnica.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private IClienteDao clienteDao;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente findBySharedKey(String shared_key) {
        return clienteDao.findById(shared_key).orElse(null);
    }

    @Override
    @Transactional
    public Cliente createNewClient(Cliente cliente) {
        clienteDao.save(cliente);
        return cliente;
    }
}
