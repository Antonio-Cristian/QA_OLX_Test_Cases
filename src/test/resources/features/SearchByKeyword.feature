@Test
Feature: SearchByKeyword

  Scenario: Search something that exists on Okazii.ro
    When I access Okazii.ro
    And I search for something that is being sold there
    Then Show all the results for that product

  Scenario: Search something that doesn't exist on Okazii.ro
    When I access Okazii.ro
    And I search for something that is not being sold there
    Then Show the no results found message