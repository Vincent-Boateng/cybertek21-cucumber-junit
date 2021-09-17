@librarian
Feature: Library app login feature
  As a user, I should be able to login with correct credentials to different accounts. And dashborad should show current account
  Accounts are: librarian, student, admin
#This is how you comment in feature file ==> use the pound sign to begin

  Background: User is already in login page
    Given user is on the login page

  @librarian1 @employee
  Scenario: Login as librarian
    #Given user is on the login page ==> if there is no Background step, then this will be the first step
    When user enters librarian username
    And user enters librarian password
    Then user should see dashboard

#@wip can be used as tag when the scenario is still a work in progress and you want to run just that one
  @student
    Scenario: Login as student
    #  Given user is on the login page
      When user enters student username
      And user enters student password
      Then user should see dashboard

    @admin @employee
    Scenario: Login as Admin
     # Given user is on the login page
      When user enters admin username
      And user enters admin password
      Then user should see dashboard