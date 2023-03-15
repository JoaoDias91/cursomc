package com.joao.cursomc.cursomc.repositories;

import com.joao.cursomc.cursomc.domain.Cliente;
import com.joao.cursomc.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
