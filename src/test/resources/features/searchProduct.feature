Feature: Search and Place Order on GreenKart Application


  Background: User is on the GreenKart e-commerce application main page
    Given user is on GreenKart main page

    @PlaceOrder
    Scenario: Search experience with Product for Both Home AND Offers Page
      Given Verify User is on the GreenKart Main Page
      When User searches with name Tom
      And Extrcated name of the Product
      Then User searched for name Tom in offers to validate if product is available
      And validate name in home page and offers page are same

  @OffersPage
  Scenario Outline: Search experience with Product for Both Home AND Offers Page
    Given Verify User is on the GreenKart Main Page
    When User searches with name <name>
    And Extrcated name of the Product
    Then User searched for name <name> in offers to validate if product is available
    And validate name in home page and offers page are same
    Examples:
      | name |
      | Tom  |
      | Cuc  |