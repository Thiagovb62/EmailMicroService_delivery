# Microserviço de Usuário e Email

## Descrição

Este projeto é um microserviço desenvolvido em Java utilizando Spring Boot e Maven. Ele fornece funcionalidades para gerenciar usuários e enviar emails. Após a criação de um usuário, uma mensagem de email é enviada automaticamente.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Maven
- RabbitMQ

## Como Usar

### Pré-requisitos

- JDK 11 ou superior
- Maven 3.6.0 ou superior
- RabbitMQ

### Passos para Executar

1. Clone o repositório:
    ```sh
    git clone <URL_DO_REPOSITORIO>
    cd <NOME_DO_DIRETORIO>
    ```

2. Compile o projeto:
    ```sh
    mvn clean install
    ```

3. Execute a aplicação:
    ```sh
    mvn spring-boot:run
    ```

### Endpoints Disponíveis

- **Criar Usuário**
    - **URL:** `/api/users`
    - **Método:** `POST`
    - **Descrição:** Cria um novo usuário e envia um email de boas-vindas.
    - **Exemplo de Request:**
        ```json
        {
            "nome": "João Silva",
            "email": "joao.silva@example.com"
        }
        ```

- **Enviar Email**
    - **URL:** `/api/emails`
    - **Método:** `POST`
    - **Descrição:** Envia um email.
    - **Exemplo de Request:**
        ```json
        {
            "destinatario": "joao.silva@example.com",
            "assunto": "Bem-vindo",
            "mensagem": "Olá João, bem-vindo ao nosso serviço!"
        }
        ```

## Funcionamento do Microserviço

### Criação de Usuário e Envio de Email

Quando um novo usuário é criado através do endpoint `/api/users`, o microserviço utiliza RabbitMQ para enviar uma mensagem para uma fila. Um consumidor, que está escutando essa fila, processa a mensagem e envia um email de boas-vindas ao novo usuário.

### Configuração do RabbitMQ

O RabbitMQ é utilizado para garantir que as mensagens de email sejam enviadas de forma assíncrona e confiável. A configuração do RabbitMQ é feita no arquivo `application.properties` ou `application.yml` do projeto.

#### Exemplo de `application.properties`:
