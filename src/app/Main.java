package app;

import model.Pagamento;
import model.Pedido;
import repository.ClienteRepository;
import repository.ProdutoRepository;
import service.LojaService;

public class Main {
    public static void main(String[] args) {
        ClienteRepository clienteRepository = new ClienteRepository();
        ProdutoRepository produtoRepository = new ProdutoRepository();
        LojaService lojaService = new LojaService(clienteRepository, produtoRepository);

        lojaService.listarClientes();
        System.out.println();

        lojaService.listarProdutos();
        System.out.println();

        System.out.println("=== CRIANDO PEDIDO ===");
        Pedido pedido = lojaService.criarPedido(1L);
        lojaService.adicionarItemAoPedido(pedido, 1L, 1);
        lojaService.adicionarItemAoPedido(pedido, 2L, 2);

        System.out.println(pedido);
        pedido.getItens().forEach(System.out::println);
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
        System.out.println();

        System.out.println("=== PROCESSANDO PAGAMENTO ===");
        Pagamento pagamento = lojaService.processarPagamento(pedido, "Cartão de Crédito");
        System.out.println(pagamento);
        System.out.println("Status final do pedido: " + pedido.getStatus());
    }
}