package br.com.fiap.nano.teste.repository;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.nano.teste.model.Produto;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryIntegrationTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	public void whenFindByName_thenReturnProduct() {
		// given
		Produto lousa = new Produto("lousa escolar 2m", 2.90);
		entityManager.persist(lousa);
		entityManager.flush();

		// when
		Produto found = produtoRepository.findByNome(lousa.getNome()).get(0);

		// then
		assertThat(found.getNome()).isEqualTo(lousa.getNome());
		assertThat(found.getPreco()).isEqualTo(lousa.getPreco());
	}
}