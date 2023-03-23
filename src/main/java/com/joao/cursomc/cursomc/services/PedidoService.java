package com.joao.cursomc.cursomc.services;

import com.joao.cursomc.cursomc.domain.Pedido;
import com.joao.cursomc.cursomc.repositories.PedidoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido buscar(Integer id){
        Optional<Pedido> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(id, Pedido.class.getName()));
    }
}
