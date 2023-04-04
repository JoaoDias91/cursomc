package com.joao.cursomc.cursomc.dto;

import com.joao.cursomc.cursomc.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private Integer id;

    @NotEmpty(message = "O Campo não pode ser vazio!")
    @Length(min = 5, max = 80, message = "O campo deve conter entre 5 e 80 caractéres")
    private String nome;

    public CategoriaDTO(){}

    public CategoriaDTO(Categoria categoria){
        id = categoria.getId();
        nome = categoria.getNome();
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
}
