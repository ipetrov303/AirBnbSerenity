Feature: Place Reservation

  Scenario: Place Reservation
    Given Don is on the home page and his region is US
    When he submits a search for the desired destination with his details:
      | destination |
      | Costa Rica  |
