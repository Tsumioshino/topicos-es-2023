import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsumidorTest {
    private Consumidor consumidor;
    private Vendedor vendedor;
    private ProdutoLoja produto;
    private ServicoPostal servico;
    private Pedido pedido;

    @BeforeEach
    public void setUp() {
        consumidor = new Consumidor(100, "Rua A");
        vendedor = new Vendedor("Loja A", 500);
        produto = new ProdutoLoja("Camiseta", 25.0, 10);
        servico = new ServicoPostal();
        pedido = new Pedido(produto, consumidor, 2);
    }

    @Test
    public void getSaldoTest() {
        double saldo = consumidor.getSaldo();
        Assertions.assertEquals(100.0, saldo);
    }

    @Test
    public void reembolsarTest() {
        consumidor.reembolsar(50.0);
        double saldo = consumidor.getSaldo();
        Assertions.assertEquals(150.0, saldo);
    }

    @Test
    public void comprarProdutoTest() {
        consumidor.comprarProduto(vendedor, produto, 2);
        double saldo = consumidor.getSaldo();
        Assertions.assertEquals(50.0, saldo);
    }

    @Test
    public void receberEntregaTest() {
        consumidor.receberEntrega(servico, pedido);
        int estoque = produto.getQtdProdutoEstoque();
        Assertions.assertEquals(8, estoque);
    }
}