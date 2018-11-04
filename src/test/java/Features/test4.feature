Feature:Launch web services


  Scenario: Launch web service
    Given Launch pet store web service
    And  user Add new pet to store
    And fetch information based on petID
    Then change status from available to sold
    And delete from inventry based on petiD

    Then get name of pet based on petID