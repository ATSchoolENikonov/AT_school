Feature: Земля

  Scenario Outline: Соединение земли
    Given Get <valueMain>
    Then Check Creation <valueMain>
    Given Get <valueAnother>
    When Connect elements <valueMain> & <valueAnother>
    Then Check Element <result>

    Examples:
      | valueMain | valueAnother | result   |
      | Earth     | Water        | Mud      |
      | Earth     | Air          | Dust     |
      | Earth     | Earth        | Pressure |
      | Earth     | Fire         | Lava     |
