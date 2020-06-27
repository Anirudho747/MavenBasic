@Login@Ex
Feature: User Login and Logout from Naukri Portal

Scenario Outline: Testing Login Feature of Naukri Portal with valid credentials
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
Then User should be able to Login to his/her Naukri Account
Examples:
|Username|Password|
|anirudho747@gmail.com|Gmail@2020|
|Username1|Password1|
|Username2|Password2|


@Logout@Single
Scenario: Testing Logout Feature of Naukri Portal
Given User is logged into his Naukri Account
When User's mouse hovers over My Naukri Option
And User clicks on Logout Option
Then User should be logged out of Naukri portal  