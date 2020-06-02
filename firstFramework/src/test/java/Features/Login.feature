Feature: Application login

Scenario Outline: Home page login
Given Initialize the browser with chrome
And navigate to "http://qaclickacademy.com"
And click on login link in home page
When user enters <emailId> and <password> and logs in
Then Verify that user is successfully logged in
And close browsers

Examples:
|emailId	      |password		|
|vp@gmail.com	  |welcome@123	|
|test123@gmail.com|67895		|