Scenario: Verify sample service
  Given a system has been initialized
  When the great request sent with user "Srilekha"
  Then the response should contains "Srilekha"