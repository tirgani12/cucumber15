Feature: Searching the employee
  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option

  @smoke
  Scenario: Search Employee by Id
    #Given open the browser and launch HRMS application
   # When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    When user enters valid employee id
    And clicks on search button
    And user see employee information is displayed
   # And close the browser

     @smoke
    Scenario: Search Employee by Job Title
     # Given open the browser and launch HRMS application
     # When user enters valid email and valid password
     # And click on login button
      #When user clicks on PIM option
      When user select Job Title
      And clicks on search button
      And user see employee information is displayed
      # And close the browser