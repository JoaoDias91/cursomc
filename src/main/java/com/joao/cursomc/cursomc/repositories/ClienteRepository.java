package com.joao.cursomc.cursomc.repositories;

import com.joao.cursomc.cursomc.domain.Categoria;
import com.joao.cursomc.cursomc.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
