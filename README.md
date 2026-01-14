📌 Login API – Testes BDD com Cucumber, RestAssured e WireMock

Este projeto demonstra a automação de testes de uma API de login utilizando BDD (Behavior Driven Development) com Cucumber (Gherkin), RestAssured para testes de API e WireMock para mockar o backend.

O objetivo é validar os principais cenários de autenticação de forma isolada, legível e alinhada ao negócio.

---

🧪 Cenários testados

O endpoint testado é:

POST /api/login

Casos cobertos:
Cenário	Status HTTP	Descrição
Login com sucesso	200	Retorna token e perfil do usuário
Credenciais inválidas	401	Usuário ou senha inválidos
Acesso negado	403	Usuário sem permissão
Usuário bloqueado	423	Usuário bloqueado no sistema

---

🧱 Tecnologias utilizadas

☕ Java

🥒 Cucumber (BDD / Gherkin)

🧪 RestAssured

🎭 WireMock (Mock da API)

🧰 JUnit

📦 Maven

---

📁 Estrutura do projeto
login-api-bdd-cucumber
├── pom.xml
└── src
└── test
├── java
│   ├── runner
│   │   └── CucumberTestRunner.java
│   └── steps
│       └── LoginSteps.java
└── resources
└── features
└── login.feature

---

📌 Descrição dos principais arquivos

login.feature

Arquivo Gherkin com os cenários de negócio (Given / When / Then)

LoginSteps.java

Implementação dos steps do Cucumber

Configuração do WireMock

Execução das chamadas via RestAssured

CucumberTestRunner.java

Classe responsável por executar os testes Cucumber

Geração do relatório HTML

pom.xml

Gerenciamento de dependências e build do projeto

---

▶️ Como executar o projeto
Pré-requisitos

Java 11 ou superior

Maven instalado

Passo a passo

Extraia o arquivo ZIP

Acesse a pasta do projeto

Execute o comando: 'mvn test'

---

📊 Relatório de testes

Após a execução, será gerado automaticamente um relatório HTML do Cucumber:

target/cucumber-report.html


Abra esse arquivo no navegador para visualizar:

Cenários executados

Status (passou/falhou)

Detalhes de cada step

---

🎭 Mock da API (WireMock)

Este projeto não depende de um backend real.

O WireMock:

Simula o endpoint /api/login

Retorna respostas diferentes conforme o cenário

Garante testes rápidos, confiáveis e isolados

---

✅ Boas práticas aplicadas

BDD com linguagem de negócio

Testes independentes

Mock de API

Código limpo e organizado

Fácil manutenção e escalabilidade

---

🚀 Possíveis evoluções

Scenario Outline + Examples

Integração com Allure Report

Execução em pipeline CI/CD

Autenticação real com JWT

Separação de Hooks globais

---

👨‍💻 Autor

Rafael Rodrigo

👨‍💻 [Github](https://github.com/rafaelrpo)

QA Automation Engineer