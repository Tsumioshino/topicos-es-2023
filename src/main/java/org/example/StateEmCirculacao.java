package org.example;

public class StateEmCirculacao implements PedidoState {
  @Override
  public void consumidorCancelamento(Pedido pedido, Consumidor consumidor) {
    throw new UnsupportedOperationException("Not supported yet.");
  }


  @Override
  public void vendedorCancelamento(Pedido pedido, Vendedor vendedor) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void finalizaTransacao(Pedido pedido) {
    throw new UnsupportedOperationException("Not supported yet.");
  //  if;(pedido.mercadoriaExtraviada()) {
   //   pedido.setSituacao(new StateExtraviado());
  //  }
  }
}
