package org.example;

public class StateCancelado implements PedidoState {
  @Override
  public void consumidorCancelamento(Pedido pedido, Consumidor vendedor) {
    System.out.println("Erro. Pedido já está cancelado.");
  }

  @Override
  public void vendedorCancelamento(Pedido pedido, Vendedor vendedor) {
    System.out.println("Erro. Pedido já está cancelado.");
  }

  @Override
  public void finalizaTransacao(Pedido pedido) {
    System.out.println("Erro. Pedido já está cancelado.");
  }
}
