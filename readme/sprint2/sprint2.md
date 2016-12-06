# Sprint 2 (11/14-11/25)

## Forecast

We forecasted we could get **16 story points** done during this sprint. We forecasted a lower value than sprint1 (21 points) due to Thanksgiving Holiday plans of team members.

The forecast correlated to the next four stories from our [Ordered Product Backlog](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#initial-product-backlog-order), with the 'Vision' Page story being introduced based on stakeholder feedback after release1:

| __Number__ | __Title__ | __Story Points__ | __Summary__
| --- | --- | --- | --- |
| 1. | 'About' content | 2 pts | As site owner, I want a page that communicates the mission of Community Table and provides visitors with key information so that they can better understand our vision and know who to contact to get involved. |
| 2. | 'Vision' Page | 3 pts | As site owner, I want a page that communicates the vision of Community Table and provides visitors with information about the future plans and overarching goals of CT. |
| 3. | Admin portal | 8 pts | As an admin I want to log in to an administrative portal so that I can perform functions that should be restricted to admins. |
| 4. | Admin list Member emails | 3 pts | As site owner, I want to be able to communicate to members via the email list, so that I can keep them informed about Community Table. |

## Actual

We were able to hit our forecasted value in the sprint (reference our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done)).
 A summary of [release2](https://github.com/michaeljohns2/CommunityTable/blob/master/README.md#release-2-notes) is is given in the main readme.
 Our stakeholders and Scrum Team agree that we are now ready to deploy
 both release1 and release2 into public production, now that further protections of Mongo and email services have been completed.
 We have deployed working code to our [incubation site](http://community-tables.vinodhalaharvi.com:8080/CommunityTables/index.html)
 and are working with our primary stakeholder to assist her in setting up her hosting environment (she is just starting her organization).
 The plan is to deploy to her site over sprint3. 

### Pull Requests
We adjusted our peer review and quality control processes to use pull requests for any new features (based on sprint1 retrospective).

![pull request example](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/pull_request.png)

### Continuous Integration / Continuous Deployment
We also solidified our CI/CD process in this sprint (started in sprint1).

![CI process](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/ci_cd.png)

#### Git WebHook

Each commit to our master `CommunityTable` repository triggers a jenkins job. 

![jenkins webhook](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/jenkins_webhook.png)

#### Jenkins Jobs

The jobs are configured in Jenkins to inject deployment specific properties, then run `mvn clean install`, then copy the 
resulting WAR file to tomcat.

![jenkins jobs](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/jenkins.png)

#### Jenkins Slackbot

We have also configured Slack bot to give live status of Jenkins jobs. 

![jenkins slackbot](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/jenkins_slack_bot.png)

### Acceptance Criteria and Sprint Tasks 

1. User Story: _'About' content_

![About Content](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/about-content-tasks.png?raw=true)

2. User Story: _'Vision' Page_

![Vision Page](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/vision-page-tasks.png?raw=true)

3. User Story: _Admin portal_

![Admin Portal](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/admin-portal-tasks.png?raw=true)

4. User Story: _Admin list Member emails_

![Admin List](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/admin-list-tasks.png?raw=true)

### Behavior-Driven Development & Unit Tests

We used Cucumber to add a new BDD test the send email functions (and possible errors) managed by [EmailRestController](https://github.com/michaeljohns2/CommunityTable/blob/master/WebApp/src/main/java/com/community/controller/rest/EmailRestController.java).
The feature exercises the detection of duplicate emails and other errors that may occur during send.

![cucumber welcome send](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/cucumber_welcome_send.png)

We also increased out unit tests to 29, bringing the project to 63% class and 50% of line coverage. While we always aim for maximum coverage,
our primary focus is on core business logic, allowing more trivial plumbing and object classes to have lower coverage.

![unit tests](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/unit_tests_sprint2.png)

## Burndown

Our burndown is based on the completion of each user story's [Sprint Task Checklist](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/sprint2.md#acceptance-criteria-and-sprint-tasks) (shown above) which were decomposed from the PBIs committed to the sprint. The last item is always "Meets Definition of Done" ([ref](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done)). 
Subsequently, our Definition of Done has a checklist item for "Acceptance criteria completed" which corresponds to the specific acceptance criteria of each user story (also shown above).

![Burndown Chart Sprint 2](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/68747-final.png?raw=true)

## Daily Scrums (1-day sample)

#### Vinod
_What did you accomplish yesterday?_
> email encryption using TLS, fixed the outage on jenkins server

_What will you do today?_
> work with @keljdoyle to get the email sent using java code

_What obstacles are impeding your progress?_
> will have to find @keljdoyle time to work together

#### Michael
_What did you accomplish yesterday?_
> merge pull requests, coordinated hosting with primary stakeholder, managed backlog

_What will you do today?_
> add logrotate to dev (throw-away) tomcat, add template in template replacement

#### Dairai
_What did you accomplish yesterday?_
> completed the templating

_What will you do today?_
> I am working on the admin page view

#### Shawn
_What did you accomplish yesterday?_
> Created about and vision page. Organized site template with _header, _nav, and _footer in separate shared files. Added and updated content. Formatted login page

_What will you do today?_
> Edit the layout of the admin page.

#### Kel
_What did you accomplish yesterday?_
> Prep for planning session

_What will you do today?_
> Research multi part emails

_What obstacles are impeding your progress?_
> Potentially accessing a test SMTP server

#### Melvin
_What did you accomplish yesterday?_
> - updated burndown chart
> - created new sprint2.md document
> - updated the assignment progress sheet

_What will you do today?_
> - standup meeting
> - will keep burndown chart and assignment progress sheet up to date
> - resolve impediments

### Impediments

_IRP = Impediment Removal Plan_

#### Shawn - Nov 24th, 12:30 pm
> Need to set up the complete system so I can test logging in to the admin.

IRP: No action needed.

#### Vinod - Nov 22nd, 08:30 pm
> will have to find @keljdoyle time to work together

IRP: Make sure Vinod syncs with Kel to set up time.

#### Kel - Nov 22nd, 08:53 am
> Potentially accessing a test SMTP server

IRP: No action needed.

#### Shawn - Nov 20th, 02:14 pm
> How can I create a new "about" page? Somehow the controller is not matching with the view. I'm guessing the model is off somehow. Can somebody create the basic MVC for an about page, and I'll fill it in with the front-end content? Thanks.

IRP: Answered in Slack.

#### Kel Doyle - Nov 17th, 02:10 pm
> Lack of Docker skillz

IRP: No action needed.

#### Kel - Nov 15th, 02:22 pm
> not really understanding how docker deployment works

IRP: No action needed.

#### Shawn - Nov 15th, 10:58 am
> I think we need to flesh out the expectations of this sprint. Maybe people can look at the backlog and starting adding their names to places where they think they can contribute. Add comments, tasks, and thoughts on the cards. Then when we meet we will have an idea of other people's thoughts and more easily break it down into chunks.

IRP: Discussed in Slack.

## Collaboration
Our Team met as a group at least 2x per week to synchronize and elevate obstacles along our critical path; additionally, individuals teamed up to pair program in order to solve various engineering tasks.  

| __Date__ | __Meeting Type__ |
| --- | --- |
| 15 NOV | Standing Team Meeting |
| 17 NOV | Standing Team Meeting |
| 21 NOV | Standing Team Meeting |
| 25 NOV | Optional Team Meeting |
| 27 NOV | Sprint Review & Retrospective |

1. Example of a peer code review (part of our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done))

![pair programming](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/pair_programming_20161125.png)

2. Example of a standing team meeting
 
![team meeting](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/team_meeting-sprint2.png)

## Sprint Review and Retrospective

We conducted our sprint review with stakeholders and Scrum Team retrospective 27 NOV. 

### Stakeholder Feeback

- Stakeholder validated our current prioritized product backlog, which has 3 stories at 26 points tied to establishing a blog capability on the site
- She is interested in generating her first blog on the Fall Baskets and stressed that she wants to include multiple pictures
- She is also wanting to add an image of her and her husband in the About Page
- Additionally, she offered some content tweaks which were able to be adjusted on the spot due to our existing support for content templates
- After the blog capability is implemented, she requests support for presenting products for sell to support the organization

_This feedback will be absorbed into the product backlog (and groomed) ahead of sprint 3 planning._
 
### Scrum Team Retrospective

- Some environment issues linger among team members; while we have increased documentation (from sprint 1 retrospective), more hands on support is needed; 
Immediately following the retrospective, team members paired up to squash their issues 
- We discussed adding Content Delivery Network (CDN) libraries in sprint 3 to further speed up page loads
- We are going to add more efficiencies to our sprint planning meeting to allow us to get moving on the next sprint
- We are going to introduce a separate channel for each user story committed within sprint 3 to foster streamlined communication and resolution
