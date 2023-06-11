package com.joao.cursomc.cursomc.services;

import com.joao.cursomc.cursomc.domain.Cidade;
import com.joao.cursomc.cursomc.repositories.CidadeRepository;
import com.joao.cursomc.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    public List<Cidade> findAll(){
        return repository.findAll();
    }

    public Cidade findById(Integer id){
        Optional<Cidade> cidade = repository.findById(id);
        return cidade.orElseThrow(() -> new ObjectNotFoundException("Cidade não encontrada"));
    }



}
