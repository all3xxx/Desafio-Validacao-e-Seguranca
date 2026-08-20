# Desafio Validação e Segurança - Java Spring Expert

Projeto desenvolvido como parte do segundo desafio da formação Java Spring Expert, da plataforma Devsuperior

## Tecnologias

- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- Banco de dados H2
- Bean Validation
- Spring Security
- OAuth2 (Authorization e Resource server)
- Maven

## Objetivo

O objetivo é implementar as funcionalidades necessárias para que os testes do projeto passem

## Diagrama de classe

<img width="619" height="227" alt="Image" src="https://github.com/user-attachments/assets/e0d857ec-4751-4260-94c8-16f4efe0c947" />

## Regras de controle de acesso

- Somente rotas de leitura (GET) de eventos e cidade são `públicas` (não requer login)
- Usuário `CLIENT` e/ou `ADMIN` podem inserir novos `eventos` (POST)
- Os demais acessos são permitidos apenas a usuário `ADMIN`

## Regras de validação

### City

- `Nome` não pode ser vazio

### Event

- `Nome` não pode ser vazio
- `Data` não pode ser data passada
- `Cidade` não pode ser nula

## Testes

Para facilitar os testes. Esta disponibilizado nos arquivos do projeto a Collection do Postman, juntamente com as Environments necessárias para realizar as requisições. Para requisições protegidas, lembre-se de fazer login.

### Usuários para os testes:

- `Ana`: CLIENT
- `Bob`: ADMIN e CLIENT

As credenciais de testes são as mesmas para ambos os usuários. Então para realizar/alternar o login entre ADMIN e CLIENT, basta mudar o valor da variável `username` da Environment, de `ana` para `bob`, ou vice-versa.

## Critérios de correção

1. POST /events deve retornar 401 Unauthorized para usuário não logado
2. POST /events deve retornar 201 Created para CLIENT logado e dados corretos
3. POST /events deve retornar 201 Created para ADMIN logado e dados corretos
4. POST /events deve retornar 422 Unproccessable Entity para ADMIN logado e nome em branco
5. POST /events deve retornar 422 Unproccessable Entity para ADMIN logado e data no passado
6. POST /events deve retornar 422 Unproccessable Entity para ADMIN logado e cidade nula
7. GET /events deve retornar 200 Ok com página de recursos
8. POST /cities deve retornar 401 Unauthorized para usuário não logado
9. POST /cities deve retornar 403 Forbidden para CLIENT logado
10. POST /cities deve retornar 201 Created para ADMIN logado e dados corretos
11. POST /cities deve retornar 422 Unprocessable Entity para ADMIN logado e nome em branco
12. GET /cities deve retornar 200 Ok com todos recursos ordenados por nome

## Competências avaliadas

- Desenvolvimento TDD de API Rest com Java e Spring Boot
- Implementação de segurança com Spring Security e OAuth2
- Controle de acesso por rotas e perfis de usuário
- Validação de dados com Bean Validation