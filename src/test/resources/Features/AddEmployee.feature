Feature:  Employee
   @smoke1
  Scenario: Adding a new Employee
  #  Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee button
    And user enters firstname an middlename and lastname
    And user clicks on save button
   # And close the browser