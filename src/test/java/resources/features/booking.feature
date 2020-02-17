Feature: Hotel search

  Scenario: Search a hotel with taing
    Given User is on the search page
    And Hotel`s name is "Чисто Отель"
    When User searches for the hotel
    Then Hotel "Чисто Отель" is displayed on the page
    And Hotel "Чисто Отель" has rating "9,3"
