package org.example;

interface PedidoState {
  public void consumidorCancelamento(Pedido pedido, Consumidor consumidor);
  public void vendedorCancelamento(Pedido pedido, Vendedor vendedor);
  public void finalizaTransacao(Pedido pedido);
}
