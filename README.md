# Calculadora Java

Uma aplicação de linha de comando desenvolvida em Java que realiza cálculos matemáticos básicos, avançados e operações com frações e matrizes. Este projeto foi estruturado no padrão **MVC (Model-View-Controller)** para fins de aprendizado.

## Funcionalidades

- Operações básicas: Soma, Subtração, Multiplicação, Divisão.
- Operações avançadas:
  - Potenciação.
  - Radiciação.
  - Módulo.
- Cálculo com frações.
- Operações com matrizes (soma, subtração e multiplicação).
- Histórico das operações realizadas.
- Estruturação do código usando o padrão MVC.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Git**: Controle de versão.
- **GitHub**: Hospedagem do código-fonte.

## Como Executar o Projeto

1. Certifique-se de ter o **JDK 17** ou superior instalado.
2. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/calculadora-java.git
   ```
3. Navegue até a pasta do projeto:
   ```bash
   cd calculadora-java
   ```
4. Compile o projeto:
   ```bash
   javac -d out src/**/*.java
   ```
5. Execute o projeto:
   ```bash
   java -cp out calculadora.controller.CalculadoraController
   ```

## Estrutura do Projeto

O projeto foi organizado utilizando o padrão MVC:

- **Model**: Contém a lógica de negócios e as classes de cálculo, como `Operacoes`, `Matriz` e `Fracao`.
- **View**: Gerencia a interação com o usuário, como exibir menus e obter entradas (`ConsoleView`).
- **Controller**: Conecta a `View` e o `Model`, gerenciando o fluxo de dados (`CalculadoraController`).

## Contribuições

Sinta-se à vontade para abrir *issues* ou enviar *pull requests*. Toda ajuda é bem-vinda para expandir as funcionalidades e melhorar o projeto!
