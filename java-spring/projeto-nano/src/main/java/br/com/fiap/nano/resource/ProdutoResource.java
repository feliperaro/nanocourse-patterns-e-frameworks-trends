package br.com.fiap.nano.resource;

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

import br.com.fiap.nano.model.Produto;
import br.com.fiap.nano.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}

	@GetMapping("{codigo}")
	public Produto buscar(@PathVariable int codigo) {
		return produtoRepository.findById(codigo).get();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Produto cadastrar(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@PutMapping("{id}")
	public Produto atualizar(@RequestBody Produto produto, @PathVariable int id) {
		produto.setCodigo(id);
		return produtoRepository.save(produto);
	}

	@DeleteMapping("{codigo}")
	public void remover(@PathVariable int codigo) {
		produtoRepository.deleteById(codigo);
	}

	@GetMapping("pesquisa")
	public List<Produto> buscar(@RequestParam(required = false) String nome,
			@RequestParam(defaultValue = "false") boolean novo) {
		return nome != null ? produtoRepository.findByNomeAndNovo(nome, novo) : produtoRepository.findByNovo(novo);
	}
}