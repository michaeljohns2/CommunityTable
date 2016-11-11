![CommunityTable is an open source project organized by the Community Tables initiative. It is a technical expression of a much more essential human drive to support _neighbors helping neighbors_._Far Vision: The most vulnerable among us often suffer alone, with limited resources and often without hope. Community Tables builds highly localizable software to strengthen and renew the social contract among neighbors, so that no one struggles in isolation again.](https://github.com/michaeljohns2/CommunityTable/blob/master/community_tables_landing.png "Title and Far Vision")

## Stakeholders (User Personas)
We have identified 3 stakeholders which drive our initiatives. We are building Community Tables products to be easily customized by any local community organizer -- captured by the term _localized_. Our initial efforts are grounded by Michelle, the Founder of Community Table TN. Michelle is our first customer and viewed as our primary stakeholder during this initial product increment. The other two stakeholders are composites of known neighbors in need and community members, respectively. Persona template adapted from [orangebus](http://orangebus.co.uk/insights/the-power-of-proto-personas).

### Michelle (Site Owner)

* _Age:_ 47
* _Gender:_ female
* _Location:_ Elizabethton, TN
* _Technical Comfort:_ fair to good 
* _Job Title:_ Founder, Community Table TN

__Backstory__ _Tell us a bit about their responsibilities and interests._ Michelle is married, a mother of three grown sons, has an undergraduate degree in the social services field, has worked/volunteered in nonprofit organizations for 7 plus years and has developed a passion to help the underserved in her Appalachian community.

__Motivations__ _How have they found or heard about the website/service? Why would they be interested?_ She is interested because the organization does not have a web presence or an effective way to communicate the message and needs of Community Table TN.

__Goals__ _What do they want to get out of this service? What are they aiming to achieve?_ To bring awareness to the public and the community about the organization and to have a viable way to sell products online and to gain financial donors to build the organization.

__Barriers__ _What would annoy them as they use it?_ If the site is incomplete or hard to maneuver.

__Quote__ _We’ll know we’ve done a good job when this persona tells us:_ 

> This website really helped bring awareness to the needs of Community Table TN and is something that the organization can use for future growth as well.

### Ruby (Neighbor in Need)

* _Age:_ 77
* _Gender:_ female
* _Location:_ Elizabethton, TN
* _Technical Comfort:_ computer illiterate
* _Job Title:_ retired retail sales

__Backstory__ _Tell us a bit about their responsibilities and interests._ Ruby is retired now for many years and has become isolated, struggling with health issues as well as the challenges of living on a social security income. Ruby feels lost after losing two daughters to cancer and the remaining daughter lives in another state. Ruby enjoys reading and occasional outings with her granddaughter whenever circumstances afford.

__Motivations__ _How have they found or heard about the website/service? Why would they be interested?_ Ruby has heard about the services through neighborhood outreach attempts. She is interested due to the resources offered and the social interaction.

__Goals__ _What do they want to get out of this service? What are they aiming to achieve?_ Mostly the social connection and the feeling that someone cares for them and will stay in consistent contact.

__Barriers__ _What would stop them from visiting, choosing and using the website/service._ Distrust or it does not meet their needs. _What would annoy them as they use it?_ If the services are inconsistent or not taking their needs into consideration.

__Quote__ _We’ll know we’ve done a good job when this persona tells us:_ 

> The baskets and neighborhood meals have given me hope and something to look forward to on a regular basis. I feel connected and valued.

### Linda (Community Member)

* _Gender:_ female
* _Age:_ 50
* _Location:_ Elizabethton, TN
* _Technical Comfort:_ fair
* _Job Title:_ retired due to disability

__Backstory__ _Tell us a bit about their responsibilities and interests._ Linda became disabled 8 years ago due to a brain aneurysm that caused a series of strokes. She has some difficulty in using her right side, but is determined to not be an invalid. Due to her medical conditions she cannot drive but she still enjoys some crafts and sewing. She is eager to help assemble baskets.

__Motivations__ _How have they found or heard about the website/service? Why would they be interested?_ Linda is interested because she still wants to be involved in activities in the community that are meaningful.

__Goals__ _What do they want to get out of this service? What are they aiming to achieve?_ A sense of purpose, a way to stay connected to others even after early retirement due to disability.

__Barriers__ _What would stop them from visiting, choosing and using the website/service._ If it is too complicated or unclear. _What would annoy them as they use it?_ Not having the resources provided to do the volunteer work effectively or if there are too many changes or cancellations by Community Table.

__Quote__ _We’ll know we’ve done a good job when this persona tells us:_ 

> I have something to look forward to each week because of the volunteer work I am doing through Community Table TN.

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

## Sprint 1 (10/8-11/11)

### Forecast

Based on the fact that we all still needed to configure the project and get it running on our localhost before we were able to begin work on the stories that actually delivered product value, we forecasted we could get **21 story points** done during this sprint.

### Burndown

![Burndown Chart Sprint 1](https://image-charts.com/chart?cht=lc&chd=t:21.00,18.67,16.33,14.00,11.67,9.33,7.00,4.67,2.33,0.00|21.00,21.00,21.00,20.42,20.42,14.00,11.67,10.50,8.17&chco=2196F3,FF5722&chxt=x,y&chxl=0:|1|2|3|4|5|6|7|8|9|10|&chs=600x200&chtt=Burndown%20Chart%20Sprint%201&chg=20,0,1,3)

### Daily Scrums (1-day sample)

#### Thursday, November 3rd

##### Michael
_What did you accomplish yesterday?_
> locally ran CommunityTable, added plugin for mvn tomcat run

_What will you do today?_
> implement cucumber tests

#### Kel
_What did you accomplish yesterday?_
> I created a setup guide and tested deployments to the host server.

_What will you do today?_
> I hope to upload an example of Java->Mongo DB connection

_What obstacles are impeding your progress?_
> none atm

#### Shawn
_What did you accomplish yesterday?_
> Gathered some images.

_What will you do today?_
> Hope to get an example Bootstrap page up and running on the server.

_What obstacles are impeding your progress?_
> Need more info on the local development env. Do I need the whole thing? Or can I just work off of the front-end side?

#### Paul
_What did you accomplish yesterday?_
> Worked on my local development environment.

_What will you do today?_
> Finish setting up local dev environment and learning Spring so I can plan on how to implement tasks.

_What obstacles are impeding your progress?_
> Need to spend time learning Spring so I can get started. Need to discuss deployment process with team.
#
#### Melvin
_What did you accomplish yesterday?_
> - created the burndown chart

_What will you do today?_
> - meeting (we need to convert the sprint backlog into tasks)
> - probably partner with someone on frontend
> - try to get project running on localhost

#### Dairai
_What did you accomplish yesterday?_
> I had to re-do my local environment setup and include missing components like mongo db

_What will you do today?_
> Identify which of the identified story points I can start on as soon as possible

##### Vinod 
_What did you accomplish yesterday?_
> setup my local dev env

_What will you do today?_
> jenkins setup for CI/CD

### Impediments

* IRP = Impediment Removal Plan

#### Shawn Roe - Nov 10th, 08:33 am
> Not sure where the welcome email html template should live in the Spring framework. Do I build the HTML welcome email for it to be sent out once a user signs up?

IRP: Needs answer.

#### Shawn Roe - Nov 8th, 08:46 am
> Waiting for the email script.

IRP: Email script was given.

#### Vinod Halaharvi - Nov 8th, 06:37 am
> link on the aws server ‘/CommunityTables/email.html’ is returning 404

IRP: Needs to be resolved.

#### Shawn Roe - Nov 3rd, 01:44 pm
> Need more info on the local development env. Do I need the whole thing? Or can I just work off of the front-end side?

IRP: Resolved.

#### Shawn Roe - Nov 1st, 09:07 am
> Want to make sure that within this MVC that "src/main/webapp" is the best place for the front-end files, like Bootstrap.css and .js and images. Yes? Better place?

IRP: Answered in Slack.

#### Dairai Nyabando - Nov 1st, 05:31 am
> I need to find a partner to work with and determine and suitable schedule

IRP: Addressed by using @channel mention, matched Dairai with a partner.

### Collaboration

![Melvin & Shawn Pair Programming](https://github.com/michaeljohns2/CommunityTable/blob/master/Screen%20Shot%202016-11-06%20at%2012.16.34%20PM%20(1).png?raw=true)

![Team Meeting/Mob Programming](https://github.com/michaeljohns2/CommunityTable/blob/master/Pasted%20image%20at%202016_11_07%2007_33%20PM.png?raw=true)

## More Info

We can also be found in Canvas [Project Group 6](https://canvas.harvard.edu/courses/18031/groups) and on our [Slack](https://agilefall2016.slack.com/messages/community_tables) channel. Our Kanban board can be found at [Trello](https://trello.com/b/i9TmhPfB/final-project-community-table).

##### This is a final project for [Agile Software Development CSCI-E71](http://agilesoftwarecourse.org/) as part of degree requirements for  [Harvard Extension School](http://www.extension.harvard.edu/).

###### Built with love in Austin, Boston, Washington DC, San Francisco, Rhode Island, and Toronto.
