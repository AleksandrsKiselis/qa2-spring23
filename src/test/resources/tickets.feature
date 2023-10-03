Feature: Air Ticket Booking

  Scenario: Successful ticket booking
    Given airports:
      | from | RIX |
      | to   | MEL |

    And passenger info is:
      | first_name | random |
      | last       | Kiselis    |

    And flight info is:
      | discount         | 3712228   |
      | passengers_count | 3          |
      | child_count      | 1          |
      | luggage_count    | 3          |
      | flight_date      | 14-05-2018 |
      | seat_nr          | 28         |

    And home page is opened

    When we are selecting airports
    Then selected airports appears on the passenger info page

    When we are filling in passenger info
    And requesting price
    And airports and price appears in flight details

    When we are confirming price
    And selecting seat number
    Then selected seat number appears

    When we are confirming seat
    Then successful registration message appears

    When we are requesting all reservations via API
    Then current reservation exists in the list
    And all data are stored correctly


