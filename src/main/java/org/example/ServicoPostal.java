package org.example;

import java.util.*;

public class ServicoPostal {
  public UUID codigo;

  public List<Pedido> getMercadorias() {
    return mercadorias;
  }

 private List<Pedido> mercadorias;

  public ServicoPostal() {
    this.codigo = UUID.randomUUID();
    this.mercadorias = new ArrayList<>();
  }
  private void entregaConsumidor(Pedido pedido, Consumidor consumidor) {
      if (pedido.getAttempt() == 3) {
          pedido.finalizaTransacao(); // vai alterar estado para devolvido
      }
      else {
          pedido.setSituacao(new StateEmCirculacao());
      }
    if (getMercadorias().contains(pedido) && consumidor.equals(pedido.getConsumidor())) {
        if (consumidor.getEndereco() == null) {
            pedido.setAttempt(pedido.getAttempt() + 1);
            pedido.setSituacao(new StateSemDestino()); // nao sei fazer d
            throw new IllegalArgumentException("Pessoa sem endereço.");
        }
        Random rand = new Random();
        double chanceFalha = 0.3;
        if (rand.nextDouble() <= chanceFalha) {
            pedido.setSituacao(new StateSemDestino());
            throw new IllegalArgumentException("Falha na entrega.");
        }
        consumidor.receberEntrega(this, pedido);
        getMercadorias().remove(pedido);
        pedido.setSituacao(new StateEntregue());
    } else {
      throw new IllegalArgumentException("Mercadoria não encontrada ou consumidor não corresponde.");
    }
  }

  private boolean devolucaoRemetente() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public void mercadoriaExtraviada(Pedido pedido) {
    if (getMercadorias().contains(pedido)) {
      pedido.setSituacao(new StateExtraviado());
      getMercadorias().remove(pedido);
    }
  }

  private void confirmacaoServicoPostal() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  public UUID getCodigo() {
    return codigo;
  }

  public void receberEntrega(Pedido pedido) {
    getMercadorias().add(pedido);
  }
}
