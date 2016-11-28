# feature/welcome_send.feature
Feature: Welcome email send
  As a site owner
  I want to send emails to new members
  so that I can welcome them to community table.

  Scenario Outline: Application able to send an email
    When User successfully registers <email>
    Then application should send a <welcome> email if valid and not duplicate
    Examples:
      | email         | welcome |
      | foo@bar.com   |  true       |
      | john@smith.cc |  true       |
      | john@smith.cc |  false      |