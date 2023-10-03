package org.example;

public class StatePendente implements PedidoState {
  @Override
  public void consumidorCancelamento(Pedido pedido, Consumidor consumidor) {
    if (pedido.getSituacao() instanceof StatePendente && pedido.getConsumidor().equals(consumidor)) {
      pedido.setSituacao(new StateCancelado());
    }
  }


  @Override
  public void vendedorCancelamento(Pedido pedido, Vendedor vendedor) {
    if ((pedido.getSituacao() instanceof StatePendente) &&
         vendedor.getProdutos().containsKey(pedido.getProduto().getNomeProduto())) {
      pedido.setSituacao(new StateCancelado());
      vendedor.reembolsoConsumidor(pedido.getProduto().getValor() * pedido.getQuantidade());
    }
  }

  @Override
  public void finalizaTransacao(Pedido pedido) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
