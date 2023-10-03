package org.example;

import java.util.*;

public class Vendedor {
  private UUID codigo;
  private String nome;

  private Map<String, ProdutoLoja> produtos;

  private Carteira carteira;

  private List<Pedido> pedidos;


  public Vendedor(String nome, double saldoInicial) {
    this.nome = nome;
    this.codigo = UUID.randomUUID();
    this.produtos = new HashMap<>();
    this.carteira = new Carteira(saldoInicial);
    this.pedidos = new ArrayList<>();
  }

  public double getSaldo() {
    return carteira.getSaldo();
  }

  public void receberReembolso(double valorReembolso) {
    carteira.adicionarSaldo(valorReembolso);
  }

  public void devolverItem(Pedido pedido) {
    pedido.getProduto().abastecimento(pedido.getQuantidade());
  }

  public void adicionarProduto(ProdutoLoja produto) {
    produtos.put(produto.getNomeProduto(), produto);
  }

  public void editarProduto(String nomeProduto, ProdutoLoja novoProduto) {
    if (produtos.containsKey(nomeProduto)) {
      produtos.put(nomeProduto, novoProduto);
    } else {
      throw new IllegalArgumentException("Produto não encontrado.");
    }
  }

  public void removerProduto(String nomeProduto) {
    if (produtos.containsKey(nomeProduto)) {
      produtos.remove(nomeProduto);
    } else {
      throw new IllegalArgumentException("Produto não encontrado.");
    }
  }

  public Carteira getCarteira() {
    return carteira;
  }

  public void setCarteira(Carteira carteira) {
    this.carteira = carteira;
  }

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }

  public void entregaServicoPostal(Pedido pedido, ServicoPostal servicoPostal) {
    pedido.entregaServicoPostal(servicoPostal);
  }

  public void reembolsoConsumidor(double saldo) {
    carteira.removerSaldo(saldo);
  }
  public void vendedorEnviou(Pedido pedido) {
    pedido.vendedorEnviou();
  }

  public UUID getCodigo() {
    return codigo;
  }

  public void setCodigo(UUID codigo) {
    this.codigo = codigo;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Map<String, ProdutoLoja> getProdutos() {
    return produtos;
  }

  public void setProdutos(Map<String, ProdutoLoja> produtos) {
    this.produtos = produtos;
  }

  public void adicionarPedido(Pedido pedido) {
    pedidos.add(pedido);
  }

  public void removerPedido(Pedido pedido) {
    pedidos.remove(pedido);
  }
}
