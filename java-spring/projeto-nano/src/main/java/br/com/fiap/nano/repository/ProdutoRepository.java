package br.com.fiap.nano.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.nano.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	List<Produto> findByNome(String prod);

	List<Produto> findByNovo(boolean novo);

	List<Produto> findByNomeAndNovo(String prod, boolean novo);

	List<Produto> findByPrecoGreaterThan(double preco);
}