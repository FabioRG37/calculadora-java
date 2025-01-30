# Calculadora em Java

Este projeto é uma calculadora em Java que suporta diversas operações matemáticas, incluindo operações com números decimais, frações, matrizes e avaliação de expressões complexas. Além disso, a calculadora mantém um histórico de operações que pode ser salvo, carregado e limpo.

## Funcionalidades

A calculadora oferece as seguintes funcionalidades:

1. **Operações com Decimais**:
    - Soma, subtração, multiplicação e divisão de números decimais.

2. **Operações com Frações**:
    - Soma, subtração, multiplicação e divisão de frações.
    - Suporte para numeradores e denominadores inteiros.

3. **Operações com Matrizes** (em desenvolvimento):
    - Soma, subtração e multiplicação de matrizes.
    - Multiplicação de matriz por escalar.
    - Cálculo da transposta de uma matriz.

4. **Expressões Complexas** (em desenvolvimento):
    - Avaliação de expressões matemáticas com operadores básicos (`+`, `-`, `*`, `/`) e parênteses.
    - Suporte para funções matemáticas (por exemplo, `sqrt`, `pow`).

5. **Histórico de Operações**:
    - Salvar o histórico de operações em um arquivo.
    - Carregar o histórico de operações salvo.
    - Limpar o histórico atual.

6. **Interface de Linha de Comando (CLI)**:
    - Menu interativo para escolher o tipo de operação.
    - Entrada e saída de dados via terminal.

## Como Executar o Projeto

### Pré-requisitos

- **Java Development Kit (JDK)**: Certifique-se de ter o JDK instalado. Recomenda-se a versão 11 ou superior.
- **Git**: Para clonar o repositório.

### Passos para Execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/FabioRG37/calculadora-java.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd calculadora-java
   ```

3. Compile o código-fonte:
   ```bash
   javac -d bin src/calculadora/*.java src/calculadora/controller/*.java src/calculadora/model/*.java src/calculadora/view/*.java
   ```

4. Execute o projeto:
   ```bash
   java -cp bin calculadora.Calculadora
   ```

5. Siga as instruções exibidas no terminal para realizar operações matemáticas.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **`src/calculadora/`**: Pacote principal do projeto.
    - **`Calculadora.java`**: Classe principal que inicia a calculadora.
- **`src/calculadora/controller/`**: Contém as classes de controle.
    - **`CalculadoraController.java`**: Gerencia o fluxo do programa e as operações.
- **`src/calculadora/model/`**: Contém as classes de modelo.
    - **`CalculadoraModel.java`**: Implementa a lógica das operações matemáticas.
- **`src/calculadora/view/`**: Contém as classes de interface com o usuário.
    - **`ConsoleView.java`**: Gerencia a interação com o usuário via terminal.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Git**: Controle de versão.
- **GitHub**: Hospedagem do repositório.

## Como Contribuir

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature ou correção:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça commit das suas alterações:
   ```bash
   git commit -m "Adicionando nova funcionalidade"
   ```
4. Envie as alterações para o repositório remoto:
   ```bash
   git push origin minha-feature
   ```
5. Abra um pull request no GitHub.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---