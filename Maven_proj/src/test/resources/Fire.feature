Feature: Огонь

  Scenario Outline: Соединение огня
    Given Get <valueMain>
    Then Check Creation <valueMain>
    Given Get <valueAnother>
    When Connect elements <valueMain> & <valueAnother>
    Then Check Element <result>

    Examples:
      | valueMain | valueAnother | result |
      | Fire      | Water        | Steam  |
      | Fire      | Air          | Energy |
      | Fire      | Earth        | Lava   |
      | Fire      | Fire         | Fire   |
