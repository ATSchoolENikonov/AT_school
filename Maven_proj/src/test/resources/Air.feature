Feature: Воздух

  Scenario Outline: Соединение воздуха
    Given Get <valueMain>
    Then Check Creation <valueMain>
    Given Get <valueAnother>
    When Connect elements <valueMain> & <valueAnother>
    Then Check Element <result>

    Examples:
      | valueMain | valueAnother | result   |
      | Air       | Water        | Rain     |
      | Air       | Air          | Pressure |
      | Air       | Earth        | Dust     |
      | Air       | Fire         | Energy   |
