# feature/email_register.feature
Feature: Member email signup
  As a member
  I want to register for the Community Table email list
  so that I can receive news and updates.

  Scenario Outline: Application able to save an email
    When I attempt to register <email>
    Then application should have <plus_one> emails
    Examples:
      | email | plus_one |
      | foo@bar.com |  1 |