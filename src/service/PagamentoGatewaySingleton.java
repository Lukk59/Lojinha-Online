package service;

import model.StatusPagamento;

import java.util.Random;

public class PagamentoGatewaySingleton {

    private static PagamentoGatewaySingleton instancia;
    private final Random random;

    private PagamentoGatewaySingleton() {
        this.random = new Random();
    }

    public static PagamentoGatewaySingleton getInstancia() {
        if (instancia == null) {
            instancia = new PagamentoGatewaySingleton();
        }
        return instancia;
    }

    public StatusPagamento processarPagamento(double valor, String formaPagamento) {
        System.out.println("Conectando ao sistema externo de pagamento...");
        System.out.println("Processando pagamento de R$ " + valor + " via " + formaPagamento);

        boolean aprovado = random.nextBoolean();

        if (aprovado) {
            System.out.println("Pagamento aprovado pelo gateway externo.");
            return StatusPagamento.APROVADO;
        } else {
            System.out.println("Pagamento recusado pelo gateway externo.");
            return StatusPagamento.RECUSADO;
        }
    }
}

/*
O padrão Singleton foi aplicado ao gateway de pagamento para garantir
que exista apenas uma única instância responsável pela comunicação com
o sistema externo durante toda a execução da aplicação.

Isso evita múltiplas conexões desnecessárias, centraliza o controle do
acesso ao serviço externo e representa melhor o papel de um componente
único de integração em uma arquitetura monolítica.
*/