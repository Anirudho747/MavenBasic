Feature: Updating User Details
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