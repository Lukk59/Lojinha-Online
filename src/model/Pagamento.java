package model;

public class Pagamento {
    private Long id;
    private Pedido pedido;
    private double valor;
    private String formaPagamento;
    private StatusPagamento status;

    public Pagamento(Long id, Pedido pedido, double valor, String formaPagamento) {
        this.id = id;
        this.pedido = pedido;
        this.valor = valor;
        this.formaPagamento = formaPagamento;
        this.status = StatusPagamento.PENDENTE;
    }

    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double getValor() {
        return valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pagamento{id=" + id +
                ", pedido=" + pedido.getId() +
                ", valor=" + valor +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", status=" + status + "}";
    }
}