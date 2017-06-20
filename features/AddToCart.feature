Feature: Add Product to the cart

  Scenario: Adding product to the cart
    Given Firefox browser is open
    And Ebay HomePage is launched
    When we search for Iphone 6s Gold
    And add it to the cart
    Then Iphone 6s should be avilable in the cart

  Scenario Outline: Adding product to the cart
    Given "<browser>" browser is open
    And Ebay HomePage is launched
    When we search for "<product>"
    And add it to the cart
    Then "<product>" should be avilable in the cart

    Examples: 
      | browser | product           |
      | IE      | bluetooth speaker |
      | chrome  | Wallet            |
