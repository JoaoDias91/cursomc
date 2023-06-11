package com.joao.cursomc.cursomc.services;

import com.joao.cursomc.cursomc.domain.Cidade;
import com.joao.cursomc.cursomc.domain.Cliente;
import com.joao.cursomc.cursomc.domain.Endereco;
import com.joao.cursomc.cursomc.domain.enums.TipoCliente;
import com.joao.cursomc.cursomc.dto.ClienteDTO;
import com.joao.cursomc.cursomc.dto.ClienteNewDTO;
import com.joao.cursomc.cursomc.repositories.ClienteRepository;
import com.joao.cursomc.cursomc.repositories.EnderecoRepository;
import com.joao.cursomc.cursomc.services.exceptions.DataIntegrityException;
import com.joao.cursomc.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

    }

    @Transactional
    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj =  repository.save(obj);
        enderecoRepository.saveAll(obj.getEnderecos());
        return obj;
    }

    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException exception){
            throw new DataIntegrityException("Não é possível deletar pois existem entidades relacionadas");
        }
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
    }

    public Cliente fromDTO(ClienteNewDTO clienteNewDTO){
        Cliente cli = new Cliente(null, clienteNewDTO.getNome(), clienteNewDTO.getEmail(), clienteNewDTO.getCpfOuCnpj(), TipoCliente.toEnumCliente(clienteNewDTO.getTipo()));
        Cidade cidade = new Cidade(clienteNewDTO.getCidadeId(), null, null);
        Endereco end = new Endereco(null, clienteNewDTO.getLogradouro(), clienteNewDTO.getNumero(), clienteNewDTO.getComplemento(), clienteNewDTO.getBairro(), clienteNewDTO.getCep(), cli, cidade);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(clienteNewDTO.getTelefone1());
        if(clienteNewDTO.getTelefone2() != null){
            cli.getTelefones().add(clienteNewDTO.getTelefone2());
        }
        if(clienteNewDTO.getTelefone3() != null){
            cli.getTelefones().add(clienteNewDTO.getTelefone3());
        }
        return cli;
    }

    private void updateData(Cliente newObj, Cliente obj){
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }
}
