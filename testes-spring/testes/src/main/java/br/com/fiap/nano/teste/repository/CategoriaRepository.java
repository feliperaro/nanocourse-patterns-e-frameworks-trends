package br.com.fiap.nano.teste.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.nano.teste.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}