Feature: Check restaurants available for correct/incorrect address
  Scenario: Restaurants are available for correct address

    Given go to 'https://www.delivery-club.ru/'
    When Enter delivery address 'Москва, проспект Андропова, 18к1'
    And Click Enter Button
    Then this rest is empty 'false'
