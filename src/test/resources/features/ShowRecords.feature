Feature: Show Records


  Scenario: verify default values in Users page
    Given I am on the login page
    When I login as a librarian
    Then I click on "Users"link
    Then show records default value should be 10
    And show records should have following options:
      | 5   |
      | 10  |
      | 15  |
      | 50  |
      | 100 |
      | 200 |
      | 500 |

