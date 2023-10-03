import org.example.StateDisponivel;
import org.example.StateIndisponivel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.ProdutoLoja;

public class ProdutoLojaTest {
  private ProdutoLoja produto;

  @BeforeEach
  public void setUp() {
    produto = new ProdutoLoja("Produto 1", 10.00, 10);
  }

  @Test
  public void testAbastecimentoNumeroNegativo() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      produto.abastecimento(-1);
    });
  }

  @Test
  public void testAbastecimentoNumeroPositivoComEstoqueMaiorQueZero() {
    produto.abastecimento(10);
    Assertions.assertEquals(20, produto.getQtdProdutoEstoque());
  }

  @Test
  public void testAbastecimentoNumeroPositivoComEstoqueIgualZero() {
    produto.setQtdProdutoEstoque(0);
    produto.disponibilidade();
    produto.abastecimento(5);
    Assertions.assertEquals(5, produto.getQtdProdutoEstoque());
  }

  @Test
  public void testAbastecimentoNenhumaQuantidade() {
    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      produto.abastecimento(0);
    });
  }

  @Test
  public void testDisponibilidadeEstadoDisponivelComEstoqueIgualZero() {
    produto.setEstoque(new StateDisponivel());
    produto.setQtdProdutoEstoque(0);
    boolean disponivel = produto.disponibilidade();
    Assertions.assertFalse(disponivel);
  }

  @Test
  public void testDisponibilidadeEstadoDisponivelComEstoqueMaiorQueZero() {
    produto.abastecimento(10);
    boolean disponivel = produto.disponibilidade();
    Assertions.assertTrue(disponivel);
  }

  @Test
  public void testDisponibilidadeEstadoIndisponivelComEstoqueMaiorQueZero() {
    produto.setEstoque(new StateIndisponivel());
    boolean disponivel = produto.disponibilidade();
    Assertions.assertTrue(disponivel);
  }

  @Test
  public void testDisponibilidadeEstadoIndisponivelComEstoqueIgualZero() {
    produto.setEstoque(new StateIndisponivel());
    produto.setQtdProdutoEstoque(0);
    boolean disponivel = produto.disponibilidade();
    Assertions.assertFalse(disponivel);
  }
}