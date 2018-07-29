Feature: Check checkbox choice result
  Scenario: Check pizza and Japan
    Given checked on food/entity
      |Выбор критиков|
      |Экспресс доставка|
    When i enter address 'Москва, Шарикоподшипниковская улица, 17'
    And click search
    Then i find 33 restaurant

  Scenario: Check critical and uncheck new
    Given checked and unchecked on food/entity
      |Выбор критиков|true|
      |Новые|false|
    When i enter address 'Москва, Шарикоподшипниковская улица, 17'
    And click search
    Then i find 33 restaurant

  Scenario: Set filter value
    Given filter value
      |paymentType|paymentValueLimit|
      |Онлайн|до 1000|
      |Картой курьеру|до 500|
    When i enter address 'Москва, Шарикоподшипниковская улица, 17'
    And click search
    Then i find 33 restaurant
