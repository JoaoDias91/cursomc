package com.joao.cursomc.cursomc.resources;

import com.joao.cursomc.cursomc.dto.ClienteNewDTO;
import com.joao.cursomc.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/cliente")
public class CadastroClienteResource {

    @Autowired
    private ClienteService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCliente(@ModelAttribute ClienteNewDTO clienteNewDTO){
        return "cliente";
    }
}
