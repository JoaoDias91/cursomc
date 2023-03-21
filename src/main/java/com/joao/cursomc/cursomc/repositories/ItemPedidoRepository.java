package com.joao.cursomc.cursomc.repositories;

import com.joao.cursomc.cursomc.domain.Categoria;
import com.joao.cursomc.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
