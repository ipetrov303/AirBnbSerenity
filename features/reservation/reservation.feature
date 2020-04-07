Feature: Place Reservation

  Scenario: Place Reservation
    Given Don is on the home page and his region is US
    When he submits a search for the desired destination with his details:
      | destination | daysFromNow | periodLength | adults | children |
      | Bali        | 5           | 7            | 2      | 1        |
    And he select first five and above star place filtered by:
      | priceFrom | priceTo | bathrooms | extras                   |
      | 50        | 100     | 1         | Air_Conditioner, Hot_Tub |


