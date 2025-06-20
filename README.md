# Gerenciador de Tarefas

Um aplicativo simples para gerenciar tarefas, permitindo criar, editar, excluir e marcar tarefas como concluídas.

## Funcionalidades

- Adicionar novas tarefas
- Editar tarefas existentes
- Excluir tarefas
- Marcar tarefas como concluídas ou pendentes
- Listagem de tarefas

## Tecnologias Utilizadas

-  Spring Boot, SPring Data, Google OAUTH Provider, H2 Database

## Instalação

```bash
git clone https://github.com/seu-usuario/gerenciador-tarefas.git
cd gerenciador-tarefas
# Siga as instruções específicas para instalar dependências e rodar o projeto
```

## Como Usar

1. Crie um arquivo `.env` na raiz do projeto para armazenar variáveis de ambiente sensíveis. Exemplo de conteúdo `.env.exemplo:

2. Acesse o [Google Cloud Console](https://console.cloud.google.com/) e crie um projeto para obter o **Client ID** e **Client Secret** OAuth 2.0. Salve essas credenciais e adicione-as ao seu arquivo `.env`:

3. Instale as dependências do projeto:

    ```bash
    ./mvnw clean install
    ```

4. Inicie a aplicação:

    ```bash
    ./mvnw spring-boot:run
    ```

5. Gere um token JWT usando o Google OAuth Playground:

    - Acesse [Google OAuth 2.0 Playground](https://developers.google.com/oauthplayground).
    - Selecione os escopos necessários para autenticação.
    - Siga o fluxo para autorizar e gerar um token de acesso.
    - Copie o token JWT gerado e utilize-o para autenticar suas requisições à API do aplicativo.

6. Teste a API utilizando um cliente como o Postman:

    - Abra o Postman (ou outro cliente de API de sua preferência).
    - Configure as requisições para os endpoints da aplicação, por exemplo:
        - `GET http://localhost:8080/tarefas` para listar tarefas.
        - `POST http://localhost:8080/tarefas` para criar uma nova tarefa.
        - `PUT http://localhost:8080/tarefas/{id}` para editar uma tarefa existente.
        - `DELETE http://localhost:8080/tarefas/{id}` para excluir uma tarefa.
    - Adicione o token JWT gerado anteriormente no cabeçalho `Authorization` das requisições:
        ```
        Authorization: Bearer SEU_TOKEN_JWT
        ```
    - Execute as requisições e utilize as respostas para criar, editar e gerenciar suas tarefas via API.



## API Pública

A API também está disponível publicamente em:

```
https://gerenciador-tarefas-p08u.onrender.com
```

Você pode utilizar essa URL para acessar os endpoints da aplicação remotamente.