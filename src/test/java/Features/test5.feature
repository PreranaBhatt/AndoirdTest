Feature:Launch web services with optimize code
  read data from property file


  Scenario: Launch web service with optimize code
    Given Launch pet store site
    And  Add new pet to store as "1617"
    And fetch data based on petID
    Then change status from available to sold based on petID
    And  get information based on changed status SOLD
