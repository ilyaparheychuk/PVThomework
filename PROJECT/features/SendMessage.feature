Feature: Test Box


Scenario Outline: Test send message
Given I am on main application page
When I login as correct user
When I click write message
When I write friend email "<email>" and theme of message "<theme>" and "<text>"
Then I see message in send
Examples:
| email   | theme    |  text  |
| iliyaparheychuk@gmail.com | I try make bot |  Hello world |
| tsogooserge@gmail.com | It is bot | Hello Serhio |