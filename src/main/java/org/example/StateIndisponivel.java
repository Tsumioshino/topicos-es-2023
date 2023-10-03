package org.example;

public class  StateIndisponivel implements ProdutoState {
  @Override
  public boolean disponibilidade(ProdutoLoja produto) {
     if (produto.getEstoque() instanceof StateIndisponivel && produto.getQtdProdutoEstoque() > 0) {
      produto.setEstoque(new StateDisponivel());
      return true;
    }
     return false;
  }
}
