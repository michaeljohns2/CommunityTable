# feature/blog_preview.feature
Feature: Public view blog entries
  As a member
  I want to view a list of all blog entries, ordered by date, newest to oldest
  so that I can keep up with site events.

  Scenario Outline: Application able to preview blogs
    When An admin writes a blog with <blog_title> and <blog_content>
    Then application should have <plus_one> blogs with <blog_preview>
    Examples:
      | blog_title    | blog_content | plus_one | blog_preview |
      | blog title 1  | content 1    | 1        | content 1    |
      | blog title 2  | content 2    | 2        | content 2    |
      | blog title 3  | content 3    | 3        | content 3    |