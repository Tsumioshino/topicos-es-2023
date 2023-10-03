package org.example;

import java.util.ArrayList;
import java.util.List;

public class Consumidor {
    public String endereco;
    private Carteira carteira;

    public Consumidor(double saldoInicial, String endereco) {
      this.carteira = new Carteira(saldoInicial);
      this.endereco = endereco;
      this.pedidosEntregues = new ArrayList<>();
    }
    public List<Pedido> getPedidosEntregues() {
      return pedidosEntregues;
    }

    public List<Pedido> pedidosEntregues;

    public double getSaldo() {
      return carteira.getSaldo();
    }

    public void reembolsar(double valorReembolso) {
      carteira.adicionarSaldo(valorReembolso);
    }

    public void comprarProduto(Vendedor vendedor, ProdutoLoja produto, int quantidade) {
      double valorTotal = produto.getValor() * quantidade;
      if (valorTotal <= carteira.getSaldo() && produto.getQtdProdutoEstoque() >= quantidade) {
        carteira.removerSaldo(valorTotal);
        produto.removerEstoque(quantidade);
        Pedido pedido = new Pedido(produto, this, quantidade);
        vendedor.adicionarPedido(pedido);
      } else {
        System.out.println("Não foi possível realizar a compra.");
      }
    }
    public String getEndereco() {
      return endereco;
    }

    public void setEndereco(String endereco) {
      this.endereco = endereco;
    }

    public void receberEntrega(ServicoPostal servico, Pedido pedido) {
      pedidosEntregues.add(pedido);
  }
}
