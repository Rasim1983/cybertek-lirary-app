Feature: Login with parameters


  @librarianParam
  Scenario: Login as librarian 13
    Given I am on the login page
    When I enter username "librarian13@library"
    And I enter password "9rf6axdD"
    And click the sign in button
    And there should be 5566 users

    Then dashboard should be displayed

  @studentParam
  Scenario: Login as student 29
    Given I am on the login page
    When I enter username "student29@library"
    And I enter password 'WyIUNpDI'
    And click the sign in button
    Then  books should be displayed

  @wip
  Scenario: Login as librarian same line
    Given I am on the login page
    When I login using "librarian13@library"and "9rf6axdD"
    Then dashboard should be displayed
    And there should be 5566 users


