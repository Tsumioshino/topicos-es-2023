package org.example;

public class ProdutoLoja {
  public String nomeProduto;
  public int qtdProdutoEstoque;
  public double valor;
  public ProdutoState estoque;

  public ProdutoLoja(String nomeProduto, double valor, int qtdProdutoEstoque) {
    if (nomeProduto.isBlank()) {
      throw new IllegalArgumentException("O nome do produto deve ser informado.");
    }

    if (valor <= 0) {
      throw new IllegalArgumentException("O valor deve ser maior que zero.");
    }

    if (qtdProdutoEstoque < 0) {
      throw new IllegalArgumentException("A quantidade do estoque deve ser maior ou igual a zero.");
    }
    this.nomeProduto = nomeProduto;
    this.valor = valor;
    this.qtdProdutoEstoque = qtdProdutoEstoque;
    if (qtdProdutoEstoque == 0) {
      this.estoque = new StateIndisponivel();
    } else {
      this.estoque = new StateDisponivel();
    }
  }

  public boolean disponibilidade() {
    return estoque.disponibilidade(this);
  }

  public void abastecimento(int quantidade) {
    if (quantidade <= 0) {
      throw new IllegalArgumentException("Não é possível abastecer estoque com quantidade menor que um.");
    }

    if (qtdProdutoEstoque >= 0) {
      qtdProdutoEstoque += quantidade;
    }
    disponibilidade();
  }
  public void removerEstoque(int quantidade) {
    if (quantidade <= 0) {
      throw new IllegalArgumentException("Não é possível remover estoque com quantidade menor que um.");
    }
    qtdProdutoEstoque -= quantidade;
  }
  public int getQtdProdutoEstoque() {
    return qtdProdutoEstoque;
  }

  public void setQtdProdutoEstoque(int qtdProdutoEstoque) {
    this.qtdProdutoEstoque = qtdProdutoEstoque;
    disponibilidade();
  }

  public String getNomeProduto() {
    return nomeProduto;
  }

  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }
  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public ProdutoState getEstoque() {
    return estoque;
  }

  public void setEstoque(ProdutoState estoque) {
    this.estoque = estoque;
  }
}