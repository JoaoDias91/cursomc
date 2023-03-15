package com.joao.cursomc.cursomc.repositories;

import com.joao.cursomc.cursomc.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
