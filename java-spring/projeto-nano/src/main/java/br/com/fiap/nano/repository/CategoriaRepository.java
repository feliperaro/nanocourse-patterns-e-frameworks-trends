package br.com.fiap.nano.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.nano.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
}