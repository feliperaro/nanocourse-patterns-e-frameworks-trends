package br.com.fiap.nano.teste.controller;

import br.com.fiap.nano.teste.model.Produto;
import br.com.fiap.nano.teste.service.impl.ProdutoServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ProdutoRestController {
	@Autowired
	private ProdutoServiceImpl service;

	@GetMapping("listar")
	public List<Produto> getAllProducts() {
		return service.getAllProdutos();
	}

	@GetMapping("{codigo}")
	public Produto buscar(@PathVariable int codigo) {
		return service.getProdutoById(codigo);
	}

	@GetMapping("pesquisar")
	public List<Produto> pesquisar(@RequestParam String nome) {
		return service.getProdutoByName(nome);
	}

	@GetMapping("contar")
	public long contar(@RequestParam double preco) {
		return service.contarPorPrecoMaior(preco);
	}

	@PostMapping("cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto cadastrar(@RequestBody Produto produto) {
		return service.save(produto);
	}

	@PutMapping("{id}")
	public Produto atualizar(@RequestBody Produto produto, @PathVariable int id) {
		produto.setCodigo(id);
		return service.save(produto);
	}

	@DeleteMapping("{codigo}")
	public void remover(@PathVariable int codigo) {
		service.deleteById(codigo);
	}
}