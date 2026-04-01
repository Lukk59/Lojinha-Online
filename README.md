# Lojinha Online - Simulação em Java

## Estrutura do Projeto
O projeto foi organizado em pacotes para separar responsabilidades:
- `model`: entidades do domínio, como Cliente, Produto, Pedido, ItemPedido e Pagamento;
- `repository`: dados estáticos simulando armazenamento de clientes e produtos;
- `service`: regras de negócio da lojinha e integração com o sistema de pagamento;
- `app`: classe principal para execução da simulação.

## Principais decisões arquiteturais
  A aplicação segue uma arquitetura cliente-servidor monolítica em forma de simulação local, concentrando toda a lógica de negócio em uma única aplicação Java.
Os clientes e produtos foram cadastrados estaticamente para simplificar a execução.
O fluxo principal contempla:
1. identificação do cliente;
2. listagem de produtos;
3. criação do pedido;
4. adição de itens;
5. processamento do pagamento;
6. confirmação ou falha da compra.

## Uso do Singleton
  O sistema foi modelado com uma arquitetura do modelo cliente-servidor monolítico, na qual toda a lógica de negócio, gerenciamento de pedidos e processamento de pagamentos ficam concentrados no servidor. O cliente apenas consome os serviços disponibilizados pela aplicação.
  
  A classe `PagamentoGatewaySingleton` implementa o padrão Singleton.Ela foi usada para representar a conexão com o sistema externo de pagamento, garantindo que exista apenas uma instância desse componente durante toda a execução do sistema.

Essa decisão foi tomada porque:
- centraliza o acesso ao gateway externo;
- evita múltiplas instâncias desnecessárias;
- facilita o controle da comunicação com o serviço de pagamento;
- combina com a ideia de um ponto único de integração em um sistema monolítico.
