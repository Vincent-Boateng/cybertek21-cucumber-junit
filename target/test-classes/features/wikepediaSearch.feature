Feature: Wikipedia search feature
  As a user, I should be able to search terms and see related results

  #The Given, When, Then keywords are just for readability among the project team, and is not
  #required for the scenarios to run, so we can even replace them with asterisks, and the program
  #will still run

@Asterisks
  Scenario: Wikipedia search title verification
    * user is on Wikipedia home page
    * user types "Steve Jobs" in the wiki search box
    * user clicks wiki search button
    * user sees "Steve Jobs" in the wiki title

  @wiki
    Scenario: Wikipedia search header verification
      Given user is on Wikipedia home page
      When user types "Steve Jobs" in the wiki search box
      And user clicks wiki search button
      Then user sees "Steve Jobs" in the main header

@wikiSearchTable
  Scenario Outline: Wikipedia search header verification
    Given user is on Wikipedia home page
    When user types "<searchValue>" in the wiki search box
    And user clicks wiki search button
    Then user sees "<expectedMainHeader>" in the main header
    Then user sees "<expectedTitle>" in the wiki title

    Examples: search terms we are going to search in wikipedia
      | searchValue  | expectedMainHeader | expectedTitle |
      | Steve Jobs   | Steve Jobs         | Steve Jobs    |
      | Kuzzat Altay | Kuzzat Altay       | Kuzzat Altay  |
      | Kobe Bryant  | Kobe Bryant        | Kobe Bryant   |
      | Elon Musk    | Elon Musk          | Elon Musk     |
      | Bill Gates   | Bill Gates         | Bill Gates    |
      | Chuck Norris | Chuck Norris       | Chuck Norris  |
      | Marie Curie  | Marie Curie        | Marie Curie   |