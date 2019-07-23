Feature: Test Login

  Scenario: Test positive spam
    Given I am on main application page
    When I login as correct user
    Then I am into InBox