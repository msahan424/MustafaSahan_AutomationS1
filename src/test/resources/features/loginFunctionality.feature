@Regression
Feature:  As a user, I should be able to log in so that I can land on homepage.
  Background:

    Given Fidexio webpage is open
    @FirstTest
    Scenario Outline: Users can log in with valid credentials
    (We have 5 types of users but will test only 2 user: PosManager, SalesManager)

      When  user enters valid email"<email>"And password "<password>"

      And user should able to login
     Then  user should see login page title

      Examples:
        | email                   | password     |
        | salesmanager20@info.com | salesmanager |
        | posmanager20@info.com   | posmanager   |
       @SecondTest
  Scenario Outline: -"Wrong login/password" should be displayed for invalid
      (valid username-invalid password and invalid username-valid password) credentials
        When user enters valid or invalid "<email>"
        And  user enters invalid or valid "<password>"
        Then Wrong login or password should be displayed
        Examples:
          | email                   | password     |
          | salesmanager20@info.com | sale12345    |
          | sales20@gmail.com       | salesmanager |
@ThirdTest
        Scenario Outline: "Please fill out this field" message should be displayed
        if the password or username is empty
          When  user enters only "<email>"

          Then user should see warning message "Please fill out this field."
          When or "<password>"
          Then user should see again warning message "Please fill out this field."
          Examples:
            | email                   | password |
            | salesmanager20@info.com |          |
            |                         | salesmanager        |


  @FourthTest
  Scenario: -User should see the password in bullet signs by default

            When user enters valid password
            Then User should see the password in bullet signs by default
@FifthTest

  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When user enters email and password
    Then user should be able to login in using the Enter key
