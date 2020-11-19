package br.com.fiap.nano.teste.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.nano.teste.model.Produto;
import br.com.fiap.nano.teste.repository.ProdutoRepository;
import br.com.fiap.nano.teste.service.ProdutoService;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Produto getProdutoById(int id) {
		return produtoRepository.findById(id).orElse(null);
	}

	@Override
	public List<Produto> getProdutoByName(String nome) {
		return produtoRepository.findByNome(nome);
	}

	@Override
	public List<Produto> getAllProdutos() {
		return produtoRepository.findAll();
	}

	@Override
	public boolean exists(String nome) {
		if (produtoRepository.findByNome(nome) != null) {
			return true;
		}
		return false;
	}

	@Override
	public Produto save(Produto prod) {
		return produtoRepository.save(prod);
	}

	@Override
	public long contarPorPrecoMaior(double preco) {
		return produtoRepository.contarPorPrecoMaior(preco);
	}

	@Override
	public void deleteById(int id) {
		produtoRepository.deleteById(id);
	}
}