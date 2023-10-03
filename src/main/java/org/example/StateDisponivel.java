package org.example;

public class StateDisponivel implements ProdutoState {
  @Override
  public boolean disponibilidade(ProdutoLoja produto) {
    if (produto.getEstoque() instanceof StateDisponivel && produto.getQtdProdutoEstoque() == 0) {
      produto.setEstoque(new StateIndisponivel());
      return false;
    }
    return true;
  }
}
