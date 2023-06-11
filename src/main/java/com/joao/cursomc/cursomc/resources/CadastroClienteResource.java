package com.joao.cursomc.cursomc.resources;

import com.joao.cursomc.cursomc.domain.Cidade;
import com.joao.cursomc.cursomc.domain.Cliente;
import com.joao.cursomc.cursomc.dto.ClienteNewDTO;
import com.joao.cursomc.cursomc.facade.ClienteFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/cliente")
public class CadastroClienteResource {

    @Autowired
    private ClienteFacade facade;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getCliente(Model model){
        List<Cidade> cidades = facade.findAllCidades();
        List<Cliente> clientes = facade.findAllClientes();
        model.addAttribute("cidades", cidades);
        model.addAttribute("clientes", clientes);
        model.addAttribute("clienteNewDTO", new ClienteNewDTO());
        return "cliente";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createCliente(Model model, @ModelAttribute ClienteNewDTO clienteNewDTO){
        Cliente cliente = facade.createCliente(clienteNewDTO);
        return "redirect:/cliente/";
    }
}
