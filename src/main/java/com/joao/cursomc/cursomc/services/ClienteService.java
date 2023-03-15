package com.joao.cursomc.cursomc.services;

import com.joao.cursomc.cursomc.domain.Cliente;
import com.joao.cursomc.cursomc.repositories.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(id, Cliente.class.getName()));
    }
}
