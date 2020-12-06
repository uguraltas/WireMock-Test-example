Feature: User CRUD oprations test

  Scenario: Adding new user successfully

    Given I start WireMock for success response

    When I adding new user with this data:
      | userName | "finartz" |
      | roleName | "admin"   |

    Then the status is 200 in the response

    And the elements equal to the followings in the response
      | message | "New user successfully have been added" |
