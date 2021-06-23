@Test2
  Feature: AddToFavorites

    Scenario: Add candy to favorite items list
      When I access Okazii.ro
      And I access the login page
      And I enter correct credentials
      Then Show my account page
      And I search for something that is being sold there
      Then Show all the results for that product
      Then Click on the first product and add it to the favorite items list