Feature:Launch book my show app in mobile and book a movie for two

  @checko
  Scenario: Launch an book my show app im mobile and do login
    Given i will open bookmyshow app in mobile
    And i will select first available movie
    And i will select seat  for two
    Then i should get payment page

