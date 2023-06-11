package com.joao.cursomc.cursomc.facade;

import com.joao.cursomc.cursomc.domain.Cidade;
import com.joao.cursomc.cursomc.domain.Cliente;
import com.joao.cursomc.cursomc.dto.ClienteNewDTO;
import com.joao.cursomc.cursomc.services.CidadeService;
import com.joao.cursomc.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteFacade {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CidadeService cidadeService;


    public List<Cidade> findAllCidades() {
        return cidadeService.findAll();
    }

    public Cliente createCliente(ClienteNewDTO clienteNewDTO) {
        Cliente cliente = clienteService.fromDTO(clienteNewDTO);
        return clienteService.insert(cliente);
    }

    public List<Cliente> findAllClientes() {
        return clienteService.findAll();
    }
}
