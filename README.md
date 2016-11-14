![CommunityTable is an open source project organized by the Community Tables initiative. It is a technical expression of a much more essential human drive to support _neighbors helping neighbors_._Far Vision: The most vulnerable among us often suffer alone, with limited resources and often without hope. Community Tables builds highly localizable software to strengthen and renew the social contract among neighbors, so that no one struggles in isolation again.](https://github.com/michaeljohns2/CommunityTable/blob/master/community_tables_landing.png "Title and Far Vision")

## Stakeholders
We have identified 3 stakeholders which drive our initiatives. We are building Community Tables products to be easily customized by any local community organizer -- captured by the term _localized_. Our initial efforts are grounded by Michelle, the Founder of Community Table TN. Michelle is our first customer and viewed as our primary stakeholder during this initial product increment. The other two stakeholders are composites of known neighbors in need and community members, respectively. Persona template adapted from [orangebus](http://orangebus.co.uk/insights/the-power-of-proto-personas).

Here are more in-depth profiles of our [Stakeholder Personas](https://github.com/michaeljohns2/CommunityTable/blob/master/stakeholders.md).


## Product Iteration (OCT-DEC 2016)
* __Name:__ Community Cloud Tables
* __Product Iteration Near Vision:__ Community Cloud Tables is a software platform to facilitate, support, and encourage neighbors helping neighbors. Through CCT's highly localizable site templates and features, community organizers can easily customize their site to raise awareness, harness membership, and communicate tailored services to those in need.
* __Key Architecture:__ 
  * Infrastructure: Amazon AWS Cloud Services
  * Java:  Spring MVC / Tomcat
  * Persistence: Mongo DB
  * JavaScript:  Bootstrap / jQuery / ReactJS

## Product Backlog
Community Tables current product backlog is available to our Scrum Team members and management at [Trello](https://trello.com/b/i9TmhPfB/final-project-community-table)

## Definition of Ready
- Title
- User story opening sentence
- Additional details
- Story point estimation
- Acceptance criteria
- Architecture

## Whole Team Relative Size Estimating Activity
We used the online tool [Pointing Poker](https://www.pointingpoker.com). After filling a PBI's Definition of Ready and discussing a few details, _only_ the development team estimated the relative size of that PBI (those wearing dual hats switched to their development hat). The high and low votes got a chance to share their reasoning. If a consensus was not reached, a second vote was taken. Convergence happened each time and the story points were recorded.

## Rationale for Backlog Order
The backlog is ordered by value generated to our stakeholders, namely Community Table TN (the first customer for our open source products). We (as well as our key stakeholder) are starting from scratch (levering other open source software frameworks where feasible). Here are the first 10 product backlog items along with their key value propositions listed to indicate which features offer more value sooner for our stakeholders. These pbis have been groomed to represent excellent users stories within our team's Definition of Ready and have been estimated by the development team. _Note: this is a snapshot as of 31 OCT 2016 and should not be used for any live data needs._ 

| __Number__ | __Title__ | __Story Points__ | __Summary__
| --- | --- | --- | --- |
| 1. | Site landing page | 8 pts | As site owner, I want a compelling landing page so that Community Table can be found by people online and they can learn about our mission and services. |
| 2. | Member email signup | 5 pts | As a member I want to register for the Community Table email list so that I can receive news and updates. |
| 3. | Welcome email on Member signup | 5 pts | As site owner, I want members to receive a welcome email when they sign-up, so that they know that we received their email address and so we can provide them with additional Community Table information. |
| 4. | Member unsubscribe email address | 3 pts | As a member, I want emails from CommunityTable to include an unsubscribe link, so I can remove myself from future mailings. |
| 5. | 'About' content | 2 pts | As site owner, I want a page that communicates the mission of Community Table and provides visitors with key information so that they can better understand our vision and know who to contact to get involved. |
| 6. | Admin portal (login required) | 8 pts | As a admin I want to log in to an administrative portal so that I can perform functions that should be restricted to admins. |
| 7. | Admin list Member emails | 3 pts | As site owner, I want to be able to communicate to members via the email list, so that I can keep them informed about Community Table. |
| 8. | Admin create blog entry | 13 pts | As site owner, I want to post a variety of articles about events, outcomes, and needs so that community members can be inspired and informed. |
| 9. | Admin delete blog entry | 5 pts | As site owner, I want to be able to delete previously created blog entries, so that I can remove older content or modify posts. |
| 10. | Public view blog entries | 8 pts | As a member, I want to view a list of all blog entries, ordered by date, newest to oldest. |

## Scrum Team
- Scrum Master / Developer (Front End): Melvin Tercan
- Product Owner / Developer (Back End/Front End): Michael Johns
- Developer (Back end) / Meeting Facilitator: Kelly J. Doyle
- Developer (Back end/Front End) / DevOps: Dairai Nyabando
- Developer (Back end): Paul Laskorski
- Developer (Front End/Back End) / DevOps: Vinod Halaharvi
- Developer (Front End) / UX Designer: Shawn Roe

## Architecture
Community Tables is a Java 8 Spring MVC web application which leverages HTML5, CSS3 and third party libraries. The primary data store is a MongoDB database. See the architecture diagram for more details:

![Architecture Diagram](https://github.com/michaeljohns2/CommunityTable/blob/master/community%20tables%20architecture.png)

## Sprint 1 (10/8-11/11)

Our sprint progress is documented at the following link:
[Sprint 1 (10/8-11/11)](https://github.com/michaeljohns2/CommunityTable/blob/master/sprint1.md)

## More Info

We can also be found in Canvas [Project Group 6](https://canvas.harvard.edu/courses/18031/groups) and on our [Slack](https://agilefall2016.slack.com/messages/community_tables) channel. Our Kanban board can be found at [Trello](https://trello.com/b/i9TmhPfB/final-project-community-table).

##### This is a final project for [Agile Software Development CSCI-E71](http://agilesoftwarecourse.org/) as part of degree requirements for  [Harvard Extension School](http://www.extension.harvard.edu/).

###### Built with love in Austin, Boston, Washington DC, San Francisco, Rhode Island, and Toronto.
