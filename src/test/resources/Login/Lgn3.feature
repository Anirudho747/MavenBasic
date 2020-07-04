Feature: User searches for Recruiters and Companies with Specifuc skillsets in specific Locations
@Rcrtr
Scenario Outline: User should be able to search for relevant jobs
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
And User clicks on Recruiter Tab
When User searches for Recuiter "<Profile>" in "<City>"
And user selects Recruiter "<City>"

Examples:
|Username|Password|Profile|City|
|anirudho747@gmail.com|Gmail@2020|API Tester|Chennai|
|anirudho747@gmail.com|Gmail@2020|Manual Test Engineer|Hyderabad|
|anirudho747@gmail.com|Gmail@2020|Automation Test Engineer|Mumbai|
|anirudho747@gmail.com|Gmail@2020|Automation Test Engineer|Chennai|

@Alrt
Scenario Outline: User should be able to create Job Alerts
Given User is on homepage
When User clicks on Login Button
And User enters "<Username>" and "<Password>"
When User's mouse hovers over My Naukri Option
And clicks on Manage and Modify Alert
And updates "<Keywords>" and "<Location>" and clicks on Update Alert
Then user should verify "<Keywords>" and "<Location>"

Examples:
|Username|Password|Keywords|Location|
|anirudho747@gmail.com|Gmail@2020|API Tester|Chennai|
|anirudho747@gmail.com|Gmail@2020|Manual Test Engineer|Hyderabad|
|anirudho747@gmail.com|Gmail@2020|Automation Test Engineer|Mumbai|
|anirudho747@gmail.com|Gmail@2020|Automation Test Engineer|Chennai|