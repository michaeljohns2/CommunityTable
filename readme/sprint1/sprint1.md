# Sprint 1 (10/8-11/11)

## Forecast

Based on the fact that we all still needed to configure the project and get it running on our localhost before we were able to begin work on the stories that actually delivered product value, we forecasted we could get **21 story points** done during this sprint.
The forecast correlated to the first four stories from our [Initial Ordered Product Backlog](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#initial-product-backlog-order):

| __Number__ | __Title__ | __Story Points__ | __Summary__
| --- | --- | --- | --- |
| 1. | Site landing page | 8 pts | As site owner, I want a compelling landing page so that Community Table can be found by people online and they can learn about our mission and services. |
| 2. | Member email signup | 5 pts | As a member I want to register for the Community Table email list so that I can receive news and updates. |
| 3. | Welcome email on Member signup | 5 pts | As site owner, I want members to receive a welcome email when they sign-up, so that they know that we received their email address and so we can provide them with additional Community Table information. |
| 4. | Member unsubscribe email address | 3 pts | As a member, I want emails from CommunityTable to include an unsubscribe link, so I can remove myself from future mailings. |

## Actual

We were able to close on all user stories forecasted within the sprint (reference our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done)). A summary of [release1](https://github.com/michaeljohns2/CommunityTable/blob/master/README.md#release-notes) is is given in the main readme.
Our stakeholders and Scrum Team agree that while release1 is feature complete under sprint1 scope, we will not attempt to deploy into public production until further protections of Mongo and email services are completed -- these are captured as tasks within existing PBIs and are prioritized for sprint2.

### Acceptance Criteria and Sprint Tasks 

1. User Story : _Site landing page_

 ![Story 1 Acceptance Criteria & Tasks](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/sprint1_story1.png)

2. User Story : _Member email signup_

 ![Story 2 Acceptance Criteria & Tasks](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/sprint1_story2.png)

3. User Story : _Welcome email on Member signup_

 ![Story 3 Acceptance Criteria & Tasks](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/sprint1_story3.png)

4. User Story : _Member unsubscribe email address_

 ![Story 4 Acceptance Criteria & Tasks](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/sprint1_story4.png)

### Behavior-Driven Development & Unit Tests

We used the [cucumber](https://cucumber.io/) framework to run our Behavior-Driven Development (BDD) tests. Specifically we tested email registration using BDD. See [email_register.feature](https://github.com/michaeljohns2/CommunityTable/blob/master/WebApp/src/test/java/features/email_register.feature), [EmailRegisterStepdefs](https://github.com/michaeljohns2/CommunityTable/blob/master/WebApp/src/test/java/stepdefs/EmailRegisterStepdefs.java), and the screenshot below (showing all tests passed). 
   
   ![cucumber](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/cucumber.png)

## Burndown

![Burndown Chart Sprint 1](https://image-charts.com/chart?cht=lc&chd=t:21.00,18.67,16.33,14.00,11.67,9.33,7.00,4.67,2.33,0.00|21.00,21.00,21.00,20.42,20.42,14.00,11.67,10.50,8.17,4.67&chco=2196F3,FF5722&chxt=x,y&chxl=0:|1|2|3|4|5|6|7|8|9|10|&chs=600x200&chtt=Burndown%20Chart%20Sprint%201&chg=20,0,1,3)

## Daily Scrums (1-day sample)

### Thursday, November 3rd

#### Michael
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

_IRP = Impediment Removal Plan_

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

## Collaboration
Our Team met as a group at least 2x per week to synchronize and elevate obstacles along our critical path; additionally, individuals teamed up to pair program in order to solve various engineering tasks.  

| __Date__ | __Meeting Type__ |
| --- | --- |
| 03 NOV | Standing Team Meeting |
| 07 NOV | Standing Team Meeting |
| 10 NOV | Standing Team Meeting |
| 13 NOV | Sprint Review & Retrospective |

1. Example of a peer code review (part of our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done))

 ![Code Review](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/code_review.png)

2. Example of an ad-hoc team meeting

 ![Ad-Hoc Team Meeting](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/team_huddle.png)

3. Example of a standing team meeting
 
 ![Standing Team Meeting](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/Pasted%20image%20at%202016_11_07%2007_33%20PM.png)

## Sprint Review and Retrospective

We conducted our sprint review with stakeholders and Scrum Team retrospective 13 NOV. 

### Stakeholder Feeback

Our primary stakeholder is pleased with the progress and completeness of our efforts. She offered the following feedback, mostly looking towards the next sprint:

- stakeholder offered additional custom content for both the landing page and welcome email (both of which are built for easy [Content Customization](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint1/site_template.png)).
- when stakeholder deploys our release public (after security tasks and admin portal are completed, estimated for release2), stakeholder wants naming convention `elizabethton.communitytabletn.com` for hosting her configured site.
- stakeholder wants to name the blog 'Table Talk' (estimated for release2).
- stakeholder wants blogs to be rendered on her Community Table TN site to show summary with image and abstract and a link to expand to read all.
- stakeholder wants to make the blog friendly for publishing to Facebook, e.g. url for each blog, Facebook able to show summary with image and abstract.

This feedback will be absorbed into the product backlog (and groomed) ahead of sprint 2 planning.
 
### Scrum Team Retrospective

While the retrospective is a generally closed door event, we chose to share these highlights:

- It took longer to get up and running across the team due to the cold-start (i.e. first sprint with no legacy to build upon) and range of technologies (reference [Product Iteration Details](https://github.com/michaeljohns2/CommunityTable/blob/master/README.md#product-iteration-oct-dec-2016)) 
- Spring MVC framework has a rather steep learning curve. More pinpointed documentation for features we are using would really help.
- Any changes should be communicated clearly to the team so everyone understands what is happening.
- We will shift to all development undertaken first within feature branches, then submitted by pull request for review and acceptance or modification. This procedural change will go far to address the feedback to communicate changes and will further enforce our two-eyes minimum code review prior as part of our  [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done). 
- We need to maintain tighter communication accross the team, especially in the final days of the sprint. We will solicit commitments for responsiveness on Slack at our next team meeting.
