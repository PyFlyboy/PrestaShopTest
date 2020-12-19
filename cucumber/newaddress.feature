Feature: AddNewAddressFeature
  This feature deals with filling the address form by the user.

  Scenario Outline: Enter the user personal data into the address form.
    Given User is logged in and address form is opened.
    When User enters "<alias>" "<address>" "<zip code>" "<city>" "<country>" "<phone>".
    And User saves information.
    Then User closes the website.


    Examples:
      | alias | address         | zip code | city   | country        | phone           |
      | JC    | Chamberlain Ave | 33415    | London | United Kingdom | +1 202 555 0156 |