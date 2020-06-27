Feature: User updates profile and searches for relevant Jobs

Scenario Outline: User should be able to search for relevant jobs
Given User is on home page
And User enter his credentials and Logs in his account
When User searches for "<Profile>" in "<City>"
And user sets his experience range
And user selects "<city>"
Then User should be able to get the count of requirements
Examples:
|Profile|City|city|
|API Tester|Chennai|Chennai|
|Manual Test Engineer|Hyderabad|Hyderabad|
|Automation Test Engineer|Mumbai|Mumbai|
|Automation Test Engineer|Chennai|Chennai|

Scenario Outline: Testing update function of Naukri portal
Given User is logged into his Naukri Account
When User clicks on Edit personal details
And User updated "<Name>" and "<Number>"
And upload Resume and Resume Headline
Then User should be able to verify "<Name>" and "<Number>"
Examples:
|Name|Number|
|Sandy|7550134740|
|Sandeep|9005754733|
|Ani|9235661481|
|Anirudh|7550134740|
 
