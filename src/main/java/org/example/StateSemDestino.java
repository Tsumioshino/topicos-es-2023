package org.example;

public class StateSemDestino implements PedidoState {
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
    pedido.setSituacao(new StateDevolvido());
    pedido.finalizaTransacao();
  }
}
