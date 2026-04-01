Instruções
Contexto
Durante a aula foi apresentado e discutido um Diagrama N0 referente a um sistema de lojinha online. Esse sistema segue uma arquitetura cliente-servidor monolítica, onde todas as responsabilidades do backend estão concentradas em uma única aplicação servidora, que se comunica com clientes e com um sistema externo de pagamento.

A partir desse diagrama inicial, você deverá evoluir a modelagem e implementar uma simulação funcional do sistema.

Descrição da Atividade
Com base no Diagrama N0 apresentado em aula, desenvolva os seguintes artefatos:

1. Diagrama de Atividades (UML)
Modele o fluxo principal de funcionamento da lojinha online.
O diagrama deve contemplar, no mínimo:
Navegação do cliente;
Seleção de produtos;
Processo de compra;
Comunicação com o sistema externo de pagamento;
Confirmação ou falha do pagamento.
2. Diagrama Entidade-Relacionamento (DER)
Modele a estrutura de dados necessária para o sistema.
O DER deve representar entidades típicas de uma lojinha online, como:
Cliente;
Produto;
Pedido;
Itens do pedido;
Pagamento.
Indique claramente:
Chaves primárias;
Chaves estrangeiras;
Relacionamentos e cardinalidades.
3. Implementação em Java (Simulação do Sistema)
Implemente uma simulação do sistema da lojinha online em Java.
A aplicação não precisa ter interface gráfica (apenas a API).
A arquitetura deve refletir o modelo cliente-servidor monolítico.
Simule as principais funcionalidades:
Identificação de cliente (crie os clientes estaticamente);
Listagem de produtos;
Criação de pedido;
Processamento de pagamento.
Requisito Obrigatório – Singleton
A conexão com o sistema externo de pagamento deve ser implementada utilizando o padrão de projeto Singleton.
O objetivo é garantir que exista apenas uma instância responsável pela comunicação com o serviço de pagamento durante toda a execução do sistema.
Justifique, em comentário ou documentação, o uso do padrão Singleton nesse contexto.
Requisitos Técnicos
Linguagem: Java
Paradigma: Orientação a Objetos
Uso de boas práticas de organização de código (pacotes, classes, responsabilidades).
Entregável: Link de Repositório contendo:
Diagrama de Atividades (imagem);
Diagrama Entidade-Relacionamento (imagem);
Código-fonte Java da simulação;
Um breve arquivo README explicando:
Estrutura do projeto;
Principais decisões arquiteturais;
Onde e como o Singleton foi aplicado.
