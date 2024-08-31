# Projeto de Controle de Investimentos

Este projeto é uma aplicação full-stack para controle de investimentos, desenvolvida com Quarkus v3 no backend e Angular v18 no frontend. A aplicação permite o gerenciamento de ativos, setores, cotações, e histórico de cotações.

## Requisitos

- **Java 17** ou superior
- **Maven 3.8.1** ou superior (utilizando o wrapper `./mvnw`)
- **Node.js 18** ou superior
- **NPM 9** ou superior

## Estrutura do Projeto

- **Backend**: Implementado com Quarkus v3, oferecendo APIs REST para manipulação dos dados.
- **Frontend**: Desenvolvido com Angular v18, oferecendo uma interface web para interação com o usuário.

## Instruções de Configuração

### 1. Configuração do Backend

1. Clone o repositório:
    ```bash
    git clone https://github.com/thaiskonishi/ceub-pos-projeto-fullstack.git
    cd api
    ```

2. Compile o projeto e instale as dependências:
    ```bash
    ./mvnw clean install
    ```

3. Execute a aplicação em modo de desenvolvimento:
    ```bash
    ./mvnw quarkus:dev
    ```

   Isso iniciará o servidor Quarkus, que estará disponível em `http://localhost:8080`.

### 2. Configuração do Frontend

1. Navegue até o diretório do frontend:
    ```bash
    cd ../frontend
    ```

2. Instale as dependências do projeto:
    ```bash
    npm install
    ```

3. Compile e rode a aplicação Angular:
    ```bash
    npm start
    ```

   O servidor de desenvolvimento do Angular será iniciado e a aplicação estará disponível em `http://localhost:4200`.

## Build para Produção

### Backend

1. Compile o backend para produção:
    ```bash
    ./mvnw clean package
    ```

2. O arquivo JAR gerado estará localizado em `target/quarkus-app`.

3. Para rodar a aplicação em modo de produção:
    ```bash
    java -jar target/quarkus-app/quarkus-run.jar
    ```

### Frontend

1. Crie a build de produção:
    ```bash
    npm run build
    ```

2. O diretório `dist/` conterá os arquivos da build de produção.

## Testes

### Backend

- Para rodar os testes do backend:
    ```bash
    ./mvnw test
    ```

### Frontend

- Para rodar os testes do frontend:
    ```bash
    npm test
    ```

## Documentação da API

Após iniciar o servidor Quarkus, a documentação da API estará disponível em `http://localhost:8080/api-docs`.

## Considerações Finais

Este projeto é apenas um protótipo e pode ser expandido para incluir mais funcionalidades, como autenticação, gráficos avançados, e integração com outros serviços de terceiros.

---

**Autor**: Thaís Maldonado Konishi
**Autor**: Vinícius de Sousa Santana
**Licença**: MIT  

# ceub-pos-projeto-fullstack

referências:

https://quarkus.io/guides/
https://material.angular.io/components/table/examples
https://material.angular.io/guide/theming
https://angular.dev/overview