package br.com.fiap.nano.teste.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@SequenceGenerator(name = "produto", sequenceName = "SQ_PRODUTO", allocationSize = 1)
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int codigo;

	@NotBlank(message = "Nome obrigatório")
	@Size(max = 50)
	private String nome;

	@Min(value = 0, message = "Preço não pode ser negativo")
	private double preco;

	private boolean novo;

	@Past
	private LocalDate dataFabricacao;

	@ManyToOne
	private Categoria categoria;

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Produto() {
	}

	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}

	public Produto(String nome, double preco, boolean novo, LocalDate dataFabricacao) {
		this.nome = nome;
		this.preco = preco;
		this.novo = novo;
		this.dataFabricacao = dataFabricacao;
	}

	public Produto(String nome, double preco, boolean novo, LocalDate dataFabricacao, Categoria categoria) {
		this.nome = nome;
		this.preco = preco;
		this.novo = novo;
		this.dataFabricacao = dataFabricacao;
		this.categoria = categoria;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}