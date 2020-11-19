package br.com.fiap.nano.teste.model;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "categoria", sequenceName = "SQ_T_CATEGORIA", allocationSize = 1)
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria")
	private int codigo;
	private String nome;

	public Categoria(String nome) {
		this.nome = nome;
	}

	public Categoria() {

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
