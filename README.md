🚀 API Tests – BDD com Cucumber, RestAssured e WireMock

Projeto de automação de testes de API utilizando BDD (Behavior Driven Development) com Cucumber, RestAssured e WireMock para simulação (mock) de serviços REST, sem dependência de backend real.

O foco é validar o endpoint de login, cobrindo múltiplos cenários de autenticação e controle de acesso, com geração de relatórios via Allure Report.

---

🧪 Tecnologias Utilizadas

Java 17+

Maven

RestAssured

Cucumber (BDD)

JUnit 5

WireMock (Mock de API)

Allure Report

---- 
📂 Estrutura do Projeto

api-bdd-wiremock
│
├── pom.xml
├── README.md
└── src
└── test
├── java
│   ├── runners
│   │   └── CucumberTestRunner.java
│   ├── steps
│   │   └── LoginSteps.java
│   ├── hooks
│   │   └── Hooks.java
│   ├── utils
│   │   └── WireMockConfig.java
│   └── support
│       └── TestContext.java
│
└── resources
├── features
│   └── login.feature
└── wiremock
└── mappings
├── login-200.json
├── login-401.json
├── login-403.json
└── login-423.json

---

🎯 Cenários Cobertos

Endpoint mockado:

POST /api/login

Casos de teste:

✅ 200 – Login com sucesso

Retorna token JWT

Retorna perfil do usuário

❌ 401 – Credenciais inválidas

🚫 403 – Acesso negado

🔒 423 – Usuário bloqueado
Todos os cenários são descritos em Gherkin e executados via Cucumber.
---
🧩 Exemplo de Feature (BDD)
Feature: Login de usuário

Scenario: Login realizado com sucesso
Given que o serviço de login está disponível
When realizo login com usuário válido
Then o status code deve ser 200
And o token JWT deve ser retornado

Scenario: Credenciais inválidas
When realizo login com credenciais inválidas
Then o status code deve ser 401
---
🔧 Mock da API (WireMock)

Como não há backend real, os endpoints são simulados com WireMock, permitindo:

Testes independentes

Execução local

Simulação de múltiplos status HTTP

Testes de contrato

Os mocks ficam em:

src/test/resources/wiremock/mappings

---

📊 Relatórios – Allure

Após a execução dos testes, é possível gerar relatórios detalhados com evidências.

Executar os testes:
mvn clean test

Gerar e abrir o relatório Allure:
mvn allure:serve


O relatório inclui:

Status dos cenários

Steps executados

Requests e responses

---

▶️ Como Executar o Projeto
Pré-requisitos:

Java 17+

Maven 3.8+

---
📌 Boas Práticas Aplicadas

BDD para alinhamento técnico e de negócio

Separação clara de responsabilidades

Testes independentes de backend

Mock de API com WireMock

Código limpo e organizado

Projeto pronto para CI/CD

---
💼 Contexto Profissional

Este projeto foi desenvolvido com foco em:

Portfólio técnico

Entrevistas de QA / Automação

Demonstração de domínio em testes de API

👨‍💻 Autor

Rafael Rodrigo
QA Automation Engineer
