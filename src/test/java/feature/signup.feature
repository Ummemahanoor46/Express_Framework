Feature: Signup Feature

  Background:
    Given user in express Homepage
    And user click on Account button

 @test
  Scenario: User should be able to sign up with valid credentials
   And user click on accept all button
    And user clicks on "join for free" link
    And user enter valid email address
    And user enter valid First Name
    And user enter valid Last Name
    And user enter password
    And user select valid "Country"
    When user click on "CREATE ACCOUNT" button
    Then the user should be able to signup successfully