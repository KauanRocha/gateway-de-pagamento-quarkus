# Gateway de Pagamento com Quarkus e Clean Architecture

Este repositório contém a implementação de um gateway de pagamento usando Quarkus e Clean Architecture. A arquitetura enfatiza a separação de preocupações, tornando o sistema modular, testável e fácil de manter. Além disso, são utilizados padrões de design como Factory e Strategy para promover um código flexível e extensível.

## Clean Architecture

A Clean Architecture, proposta por Robert C. Martin, também conhecido como Uncle Bob, é uma abordagem para o design de sistemas de software que prioriza a separação de conceitos em diferentes camadas. Essa arquitetura consiste em várias camadas concêntricas, cada uma com sua responsabilidade específica e dependências unidirecionais, resultando em um sistema altamente desacoplado e testável.

### Principais Componentes:

1. **Entities (Entidades)**: Representam objetos de negócio puros, sem dependências externas. Elas encapsulam o estado e as operações relacionadas a um conceito específico do domínio.

2. **Use Cases (Casos de Uso)**: Implementam as regras de negócio da aplicação. Eles orquestram a interação entre as entidades e os mecanismos de entrada e saída, garantindo que as operações de alto nível sejam executadas de acordo com as políticas de negócio.

3. **Interfaces (Interfaces do Sistema)**: Definem os contratos entre as camadas da aplicação. Elas permitem a comunicação entre os casos de uso e os mecanismos externos, como interfaces de usuário, serviços externos ou bancos de dados.

4. **Frameworks e Drivers (Frameworks e Drivers Externos)**: São os componentes externos à aplicação, como frameworks, bibliotecas e serviços. Eles são os detalhes técnicos que devem ser mantidos do lado de fora da arquitetura limpa.

## Padrões de Design Utilizados

Além da Clean Architecture, este projeto utiliza dois padrões de design importantes:

1. **Factory (Fábrica)**: O padrão Factory é utilizado para encapsular a lógica de criação de objetos. Ele permite a criação de objetos sem especificar a classe exata do objeto que será criado, fornecendo uma interface para criar objetos em uma hierarquia de classes.

2. **Strategy (Estratégia)**: O padrão Strategy é utilizado para definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. Ele permite que o algoritmo varie independentemente dos clientes que o utilizam, proporcionando flexibilidade e extensibilidade ao sistema.

## Funcionalidades

- **Processamento de Pagamentos Robusto**: Funcionalidade de processamento de pagamentos segura e confiável.
- **Framework Quarkus**: Utiliza o Quarkus para desenvolvimento eficiente e escalável.
- **Clean Architecture**: Segue os princípios da Clean Architecture para código organizado e de fácil manutenção.
- **Padrões de Design**: Incorpora padrões de design como Factory e Strategy para flexibilidade e extensibilidade.

## Utilização

Para usar o gateway de pagamento, siga estes passos:

1. Clone o repositório: `git clone https://github.com/KauanRocha/gateway-de-pagamento-quarkus.git`
2. Navegue até o diretório do projeto: `cd payment-gateway`
3. Construa o projeto: `mvn clean install`
4. Execute a aplicação: `mvn quarkus:dev`
5. Acesse o gateway de pagamento em `http://localhost:8080`

## Contribuições

Contribuições são bem-vindas! Se você deseja contribuir para este projeto, siga estes passos:

1. Faça um fork do repositório.
2. Crie uma nova branch: `git checkout -b feature/nova-feature`
3. Faça suas alterações e as commit: `git commit -m 'Adicionar nova feature'`
4. Faça o push para a branch: `git push origin feature/nova-feature`
5. Envie uma pull request.
