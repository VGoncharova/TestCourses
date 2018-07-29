Feature: Change Banner feature. Check that banners changes by click
  Scenario: FromFirstToSecond
    Given Go to 'https://www.delivery-club.ru/'
    When click to 1 banner round
    And click to 'right' banner button
    Then we see 'https://r.mradx.net/img/A9/D8F161.jpg' image url

  Scenario: FromSecondToThird
    Given Go to 'https://www.delivery-club.ru/'
    When click to 2 banner round
    And click to 'right' banner button
    Then we see 'https://r.mradx.net/img/26/C7D6BA.jpg' image url

  Scenario: FromThirdToFour
    Given Go to 'https://www.delivery-club.ru/'
    When click to 3 banner round
    And click to 'right' banner button
    Then we see 'https://r.mradx.net/img/A3/473FE9.jpg' image url