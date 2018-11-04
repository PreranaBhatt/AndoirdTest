Feature:Launch web services with optimize code
  read data from property file and will do validation  for ID ,value

  @API
  Scenario: Launch web service with optimize code
    Given Launch pet store site for demo
    And fetch data based on given petID as "1617"

    And  send post request to pet site




