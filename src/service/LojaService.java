package service;

import model.*;
import repository.ClienteRepository;
import repository.ProdutoRepository;

import java.util.concurrent.atomic.AtomicLong;

public class LojaService {
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    private final AtomicLong geradorPedido = new AtomicLong(1);
    private final AtomicLong geradorItem = new AtomicLong(1);
    private final AtomicLong geradorPagamento = new AtomicLong(1);

    public LojaService(ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public void listarClientes() {
        System.out.println("=== CLIENTES ===");
        clienteRepository.listarTodos().forEach(System.out::println);
    }

    public void listarProdutos() {
        System.out.println("=== PRODUTOS ===");
        produtoRepository.listarTodos().forEach(System.out::println);
    }

    public Pedido criarPedido(Long idCliente) {
        Cliente cliente = clienteRepository.buscarPorId(idCliente);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        Pedido pedido = new Pedido(geradorPedido.getAndIncrement(), cliente);
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);
        return pedido;
    }

    public void adicionarItemAoPedido(Pedido pedido, Long idProduto, int quantidade) {
        Produto produto = produtoRepository.buscarPorId(idProduto);

        if (produto == null) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }

        produto.reduzirEstoque(quantidade);

        ItemPedido item = new ItemPedido(geradorItem.getAndIncrement(), produto, quantidade);
        pedido.adicionarItem(item);
    }

    public Pagamento processarPagamento(Pedido pedido, String formaPagamento) {
        Pagamento pagamento = new Pagamento(
                geradorPagamento.getAndIncrement(),
                pedido,
                pedido.calcularTotal(),
                formaPagamento
        );

        PagamentoGatewaySingleton gateway = PagamentoGatewaySingleton.getInstancia();
        StatusPagamento status = gateway.processarPagamento(pagamento.getValor(), formaPagamento);

        pagamento.setStatus(status);

        if (status == StatusPagamento.APROVADO) {
            pedido.setStatus(StatusPedido.CONFIRMADO);
        } else {
            pedido.setStatus(StatusPedido.PAGAMENTO_FALHOU);
        }

        return pagamento;
    }
}