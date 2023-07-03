Feature: Вода

  Scenario Outline: Соединение воды
    Given Get <valueMain>
    Then Check Creation <valueMain>
    Given Get <valueAnother>
    When Connect elements <valueMain> & <valueAnother>
    Then Check Element <result>

    Examples:
      | valueMain | valueAnother | result |
      | Water     | Water        | Sea    |
      | Water     | Air          | Rain   |
      | Water     | Earth        | Mud    |
      | Water     | Fire         | Steam  |
