Feature: Login

  Scenario: Correct Credentials

    Given I open home page of Automation Store
    When  I click on account baner
    And   I type "KonRafal" as login in login page
    And   I type "n8QSi@43HVSF" as password in login page
    And   i click Login button
    Then  I'm logged in

  Scenario: Incorrect Credentials
    Given I open home page of Automation Store
    When  I click on account baner
    And   I type "KonRafal" as login in login page
    And   I type "n8QSi@43HVSX" as password in login page
    And   i click Login button
    Then  I'm not logged in

  Scenario: Correct Credentials short
    Given I open home page of Automation Store and click on account baner
    When  I type "KonRafal" as login, "n8QSi@43HVSF" as password in login page and click login button
    Then  I'm logged in

  Scenario: Incorrect Credentials short
    Given I open home page of Automation Store and click on account baner
    When  I type "KonRafal" as login, "n8QSi@43HVSX" as password in login page and click login button
    Then  I'm not logged in

  Scenario Outline: Check Credentials
    Given I open home page of Automation Store and click on account baner
    When  I type "<login>" as login, "<password>" as password in login page and click login button
    Then  <expectedResult>

    Examples:
      | login    | password     | expectedResult    |
      | KonRafal | n8QSi@43HVSF | I'm logged in     |
      | KonRafal | n8QSi@43HVSX | I'm not logged in |
      | RafalKon | n8QSi@43HVSF | I'm not logged in |
      | RafalKon | n8QSi@43HVSX | I'm not logged in |