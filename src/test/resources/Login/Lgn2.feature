Feature: User updates profile and searches for relevant Jobs

@Srch
Scenario Outline: User should be able to search for relevant jobs
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
When User searches for "<Profile>" in "<City>"
And user sets his experience range
And user selects "<City>"
Then User should be able to get the count of requirements
Examples:
|Username|Password|Profile|City|
|anirudho747@gmail.com|Gmail@2020|API Tester|Chennai|
|anirudho747@gmail.com|Gmail@2020|Manual Test Engineer|Hyderabad|
|anirudho747@gmail.com|Gmail@2020|Automation Test Engineer|Mumbai|
|anirudho747@gmail.com|Gmail@2020|Automation Test Engineer|Chennai|

@Updt
Scenario Outline: Testing update function of Naukri portal
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
And User clicks on Edit personal details
And User updated "<Name>" and "<Number>"
And upload Resume and Resume Headline
Then User should be able to verify "<Name>" and "<Number>"
Examples:
|Username|Password|Name|Number|
|anirudho747@gmail.com|Gmail@2020|Sandy|7550134740|
|anirudho747@gmail.com|Gmail@2020|Sandeep|9005754733|
|anirudho747@gmail.com|Gmail@2020|Ani|9235661481|
|anirudho747@gmail.com|Gmail@2020|Anirudh|7550134740|
 
