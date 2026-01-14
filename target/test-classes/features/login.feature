Feature: Login API

  Scenario Outline: Login com diferentes respostas
    Given que informo usuario "<usuario>" e senha "<senha>"
    When realizo o login
    Then o status code deve ser <status>

    Examples:
      | usuario    | senha    | status |
      | valido     | valido   | 200    |
      | invalido   | invalido | 401    |
      | bloqueado  | valido   | 423    |
