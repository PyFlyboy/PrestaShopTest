Feature: NewPurchaseFeature
  This feature deals with a purchase execution by a registered user.

  Scenario Outline: User purchases one type of product.

    Given Website is open.
    When User enter "<email>" and "<password>".
    And  User searches for product.
    And User clicks on selected product.
    And User selects the "<size>" and "<quantity>".
    And User adds the product to the cart.
    And User proceeds to checkout.
    And User confirms address.
    And User selects pick up in store.
    And User selects pay by check.
    And User finilizes the order with an obligation to pay.
    Then User closes the browser.

    Examples:
      | email            | password   | size | quantity |
      | do.tomasza@wp.pl | Master12!@ | L    | 5        |
