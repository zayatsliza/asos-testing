Feature: smoke
  As a user
  I want to test all main functional
  So that I can be sure that site works correctly
  Scenario Outline: Check sign up functionality with all correct input
    Given User opens '<homePage>' page
    When User clicks on 'Account' icon
    And User clicks on register button
    And User fills in '<emailAddress>' field
    And User fills in first name value = '<firstName>'
    And User fills in last name value = '<lastName>'
    And User fills in password value = '<password>'
    And User selects day of birth
    And User selects month of birth
    And User selects year of birth
    And User selects preference of wear
    And User clicks on 'Join Asos' button
    Then User gets '<homePage>' page
    And User clicks on 'Account' icon on home page
    And User sees 'Hi '<firstName>''
    Examples:
      | homePage              | emailAddress             | firstName | lastName   | password         |
      | https://www.asos.com/ | pleaseworkauto@gmail.com | Test      | Automation | Automationadmin1 |

  Scenario Outline: Check sign up functionality with incorrect password
    Given User opens '<homePage>' page
    When User clicks on 'Account' icon
    And User clicks on register button
    And User fills in '<emailAddress>' field
    And User fills in first name value = '<firstName>'
    And User fills in last name value = '<lastName>'
    And User fills in password value = '<password>'
    Then User gets password error message
    And User selects day of birth
    And User selects month of birth
    And User selects year of birth
    And User selects preference of wear
    And User clicks on 'Join Asos' button
    Examples:
      | homePage              | emailAddress             | firstName | lastName   | password |
      | https://www.asos.com/ | pleaseworkauto@gmail.com | Test      | Automation | A123     |
  Scenario Outline: Check sign in functionality with correct inputs
  Given User opens '<homePage>' page
    When User clicks on 'Account' icon
    And User clicks on sign in button
    And User fills in email address = '<emailAddress>' field on sign in page
    And User fills in password address = '<password>' field on sign in page
    And User clicks on 'Sign In' button
    Then User gets '<homePage>' page
    And User clicks on 'Account' icon on home page
    And User sees 'Hi '<firstName>''
    Examples:
      | homePage              | emailAddress             | password         | firstName |
      | https://www.asos.com/ | pleaseworkauto@gmail.com | Automationadmin1 | Test      |

  Scenario Outline: Check visibility of icons on home page
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks search field visibility
    And User checks wish list icon visibility
    And User checks cart icon visibility
    And User checks women button visibility
    And User checks account icon visibility
    When User clicks on 'Account' icon on home page
    And User checks sign in button visibility
    And User checks register button visibility
    When User clicks on register button
    And User checks email field visibility
    And User checks first name and last name fields visibility
    And User checks password field visibility
     Examples:
     | homePage              |
     | https://www.asos.com/ |
  Scenario Outline: Check searching and add to wish list functionality
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User adds to wish list first and third items
    And User clicks on wish list icon
    Then User checks that amount of items in wish list are '<amountOfItem>'
    Examples:
      | homePage              | keyword | amountOfItem |
      | https://www.asos.com/ | sport   | 2 items      |
  Scenario Outline: Check adding items to shopping cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    When User makes search by '<keyword>'
    And User clicks at last items on a page
    And User selects size of item
    And User adds to cart item
    Then User checks that amount of items in cart are '<amountOfItem>'
    Examples:
      | homePage              | keyword | amountOfItem |
      | https://www.asos.com/ | jeans   | 1            |