Feature: Etsy search feature


  Scenario: Etsy default title verification
    Given user is on the Etsy landing page
    Then user should see Etsy title as expected

  @etsy
    Scenario: Etsy search title verification
      Given user is on the Etsy landing page
      When user searches for "wooden spoon"
      Then user should see "Wooden spoon" in the Etsy Title