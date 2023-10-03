package org.example;

public class StateDevolvido implements PedidoState {
  @Override
  public void consumidorCancelamento(Pedido pedido, Consumidor consumidor) {
    System.out.println("Erro. Pedido já está finalizado.");
  }


  @Override
  public void vendedorCancelamento(Pedido pedido, Vendedor vendedor) {
    System.out.println("Erro. Pedido já está finalizado.");
  }

  @Override
  public void finalizaTransacao(Pedido pedido) {
    System.out.println("Erro. Pedido já está finalizado.");
  }
}
