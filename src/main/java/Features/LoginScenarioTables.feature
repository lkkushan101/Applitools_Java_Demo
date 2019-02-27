Feature: Search Google
  Scenario: Search Selenide Word in Google

    Given Im in the guru bank login page
    When I enter <userName> and <password>
	| userName   | password |
	| mngr176797 | jaseteb  |
    Then I should able to navigate to the home page
