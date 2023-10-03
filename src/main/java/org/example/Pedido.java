package org.example;

public class Pedido {
  private ProdutoLoja produto;
  private Consumidor consumidor;
  PedidoState situacao;
  String reclamacao;

  public int getQuantidade() {
    return quantidade;
  }

  private int quantidade;

  private int attempt;

  public int getAttempt() {
    return attempt;
  }

  public void setAttempt(int attempt) {
    this.attempt = attempt;
  }

  public boolean isVendedorConfirmou() {
    return vendedorConfirmou;
  }

  public void setVendedorConfirmou(boolean vendedorConfirmou) {
    this.vendedorConfirmou = vendedorConfirmou;
  }

  public boolean isVendedorEnviou() {
    return vendedorEnviou;
  }

  public void setVendedorEnviou(boolean vendedorEnviou) {
    this.vendedorEnviou = vendedorEnviou;
  }

  public boolean isEntregaServicoPostal() {
    return entregaServicoPostal;
  }

  public void setEntregaServicoPostal(boolean entregaServicoPostal) {
    this.entregaServicoPostal = entregaServicoPostal;
  }

  private boolean vendedorConfirmou;
  private boolean vendedorEnviou;
  private boolean entregaServicoPostal;

  public Pedido(ProdutoLoja produto, Consumidor consumidor, int quantidade) {
    produto.setQtdProdutoEstoque(produto.getQtdProdutoEstoque() - quantidade);

    this.produto = produto;
    this.consumidor = consumidor;
    this.situacao = new StatePendente();
    this.vendedorConfirmou = false;
    this.vendedorEnviou = false;
    this.entregaServicoPostal = false;
    this.attempt = 0;
    this.quantidade = quantidade;
  }

  public void consumidorCancelamento() {
    situacao.consumidorCancelamento(this, this.getConsumidor()
    );
  }

  public void vendedorCancelamento(Vendedor vendedor) {
    situacao.vendedorCancelamento(this, vendedor);
  }

  public void finalizaTransacao() {
    situacao.finalizaTransacao(this);
  }
  public void confirmacaoVendedor() {
    setVendedorConfirmou(true);
  }

  public void vendedorEnviou() {
    if (situacao instanceof StatePendente && vendedorConfirmou) {
      setVendedorEnviou(true);
      setSituacao(new StateEmCirculacao());
    }
  }

  public void entregaServicoPostal(ServicoPostal servicoPostal) {
    if (vendedorEnviou) {
      servicoPostal.receberEntrega(this);
      setEntregaServicoPostal(true);
    }
  }

  public void reembolsar(Vendedor vendedor) {
    if (vendedor.getProdutos().containsKey(getProduto().getNomeProduto()))   {
      vendedor.reembolsoConsumidor(this.getProduto().getValor() * this.getQuantidade());
      consumidor.reembolsar(this.getProduto().getValor() * this.getQuantidade());

    }
    vendedor.receberReembolso(this.getProduto().getValor() * this.getQuantidade());
    vendedor.devolverItem(this);
  }

  public PedidoState getSituacao() {
    return situacao;
  }

  public void setSituacao(PedidoState situacao) {
    this.situacao = situacao;
  }

  public String getReclamacao() {
    return reclamacao;
  }

  public void setReclamacao(String reclamacao) {
    this.reclamacao = reclamacao;
  }


  public ProdutoLoja getProduto() {
    return produto;
  }

  public void setProduto(ProdutoLoja produto) {
    this.produto = produto;
  }

  public Consumidor getConsumidor() {
    return consumidor;
  }

  public void setConsumidor(Consumidor consumidor) {
    this.consumidor = consumidor;
  }
}
