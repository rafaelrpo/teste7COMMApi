
Feature: Usuário autenticado

  Scenario: Consultar usuário logado
    Given que estou autenticado
    When consulto meus dados
    Then o status code deve ser 200
