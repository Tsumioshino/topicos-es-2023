import org.example.Consumidor;
import org.example.Pedido;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.Vendedor;
import org.example.ProdutoLoja;

class VendedorTest {
  private Vendedor vendedor;

  @BeforeEach
  void setup() {
    vendedor = new Vendedor("João", 500.00);
  }

  @Test
  void testAdicionarProduto() {
    ProdutoLoja produto = new ProdutoLoja("Camiseta", 29.99, 50);
    vendedor.adicionarProduto(produto);

    Assertions.assertTrue(vendedor.getProdutos().containsKey("Camiseta"));
    Assertions.assertEquals(produto, vendedor.getProdutos().get("Camiseta"));
  }

  @Test
  void testEditarProduto() {
    ProdutoLoja produtoAntigo = new ProdutoLoja("Camiseta", 29.99, 50);
    ProdutoLoja produtoNovo = new ProdutoLoja("Camiseta", 39.99, 100);

    vendedor.adicionarProduto(produtoAntigo);
    vendedor.editarProduto("Camiseta", produtoNovo);

    Assertions.assertEquals(produtoNovo, vendedor.getProdutos().get("Camiseta"));
  }

  @Test
  void testRemoverProduto() {
    ProdutoLoja produto = new ProdutoLoja("Camiseta", 29.99, 50);
    vendedor.adicionarProduto(produto);

    vendedor.removerProduto("Camiseta");

    Assertions.assertFalse(vendedor.getProdutos().containsKey("Camiseta"));
  }

  @Test
  public void adicionarPedidoTest() {
    // Criação de um pedido de exemplo
    Consumidor consumidor = new Consumidor(50.0, "Rua dos Jargoes");
    ProdutoLoja produto = new ProdutoLoja("Camiseta", 25.0, 10);
    int quantidade = 2;
    Pedido pedido = new Pedido(produto, consumidor, quantidade);

    // Adiciona o pedido ao vendedor
    vendedor.adicionarPedido(pedido);

    // Verifica se o pedido foi adicionado corretamente
    Assertions.assertEquals(1, vendedor.getPedidos().size());
    Assertions.assertEquals(pedido, vendedor.getPedidos().get(0));
  }

  @Test
  public void receberReembolsoTest() {
    // Realiza um reembolso de exemplo
    double valorReembolso = 50.0;
    vendedor.receberReembolso(valorReembolso);

    // Verifica se o saldo do vendedor foi atualizado corretamente
    Assertions.assertEquals(550.0, vendedor.getSaldo());
  }

  @Test
  public void removerPedidoTest() {
    Consumidor consumidor = new Consumidor(50.0, "Rua dos Jargoes");
    ProdutoLoja produto = new ProdutoLoja("Camiseta", 25.0, 10);
    Pedido pedido = new Pedido(produto, consumidor, 2);

    vendedor.adicionarPedido(pedido);
    vendedor.removerPedido(pedido);

    Assertions.assertEquals(0, vendedor.getPedidos().size());
  }

  @Test
  public void devolverItemTest() {
    Consumidor consumidor = new Consumidor(50.0, "Rua dos Jargoes");
    ProdutoLoja produto = new ProdutoLoja("Camiseta", 25.0, 10);
    Pedido pedido = new Pedido(produto, consumidor, 2);

    vendedor.adicionarPedido(pedido);
    vendedor.devolverItem(pedido);

    Assertions.assertEquals(10, produto.getQtdProdutoEstoque());
  }
}