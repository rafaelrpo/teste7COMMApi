
Feature: Login

  Scenario: Login com sucesso
    Given que possuo usuário "usuario.valido" e senha "senha.valida"
    When realizo o login
    Then o status code deve ser 200
    And deve retornar um token JWT

  Scenario: Credenciais inválidas
    Given que possuo usuário "usuario.invalido" e senha "senha.errada"
    When realizo o login
    Then o status code deve ser 401

  Scenario: Acesso negado
    Given que possuo usuário "usuario.sem.permissao" e senha "senha.valida"
    When realizo o login
    Then o status code deve ser 403

  Scenario: Usuário bloqueado
    Given que possuo usuário "usuario.bloqueado" e senha "senha.valida"
    When realizo o login
    Then o status code deve ser 423
