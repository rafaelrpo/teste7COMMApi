Feature: Login na API

  Scenario: Login com sucesso
    Given que o usuário é válido
    When realiza login com credenciais corretas
    Then o sistema retorna status 200
    And retorna um token e perfil do usuário

  Scenario: Credenciais inválidas
    Given que as credenciais são inválidas
    When realiza login
    Then o sistema retorna status 401

  Scenario: Acesso negado
    Given que o usuário não tem permissão
    When realiza login
    Then o sistema retorna status 403

  Scenario: Usuário bloqueado
    Given que o usuário está bloqueado
    When realiza login
    Then o sistema retorna status 423
