@Test
Feature: Login

  Scenario: Login with correct credentials
    When I access Okazii.ro
    And I access the login page
    And I enter correct credentials
    Then Show my account page
    And I'm logged in
    Then Logout

  Scenario: Login with wrong credentials
    When I access Okazii.ro
    And I access the login page
    And I enter wrong credentials
    Then Show error message