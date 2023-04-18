package com.joao.cursomc.cursomc.dto;

import com.joao.cursomc.cursomc.domain.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {

    private Integer id;
    @NotEmpty(message = "O Campo não pode ser vazio!")
    @Length(min = 5, max = 120, message =  "O campo deve conter entre 5 e 120 caractéres")
    private String nome;
    @NotEmpty(message = "O Campo não pode ser vazio!")
    @Email(message = "Email inválido!")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
