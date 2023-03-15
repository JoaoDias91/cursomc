package com.joao.cursomc.cursomc;

import com.joao.cursomc.cursomc.domain.*;
import com.joao.cursomc.cursomc.domain.enums.TipoCliente;
import com.joao.cursomc.cursomc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Collections.singletonList(p2));

		p1.getCategorias().addAll(Collections.singletonList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Collections.singletonList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 =  new Cidade (null, "Campinas", est2);
		Cidade cid3 = new Cidade (null, "São Paulo", est2);

		est1.getCidades().addAll(Collections.singletonList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Cliente cli1 = new Cliente(null, "Maria Silva",
				"maria@gmail.com", "437.476.630-87",
				TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("12340-12345", "321345-321543"));
		Endereco e1 = new Endereco(null,
				"Rua Flores", "121", "Bl23"
				,"Vila formosa", "09898-000", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "32B",
				"Predio 2", "Jardim Alvarenga","08717-333", cli1, cid2);

		clienteRepository.saveAll(Collections.singletonList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
	}
}
