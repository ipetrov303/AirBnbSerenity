Feature: Reservation

  @eur_currency
  Scenario: Place Reservation with Correct Details
    Given Bob is on the home page
    When he searches for booking options with preferences:
      | destination | daysFromNow | periodLength | adults | children |
      | Bali        | 5           | 7            | 2      | 1        |
    And he selects the first place with at least 5 stars from the options filtered by:
      | priceFrom | priceTo | bathrooms | extras                   |
      | 50        | 100     | 1         | Air_Conditioner, Hot_Tub |
    Then the booking details are displayed correctly
