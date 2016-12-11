# Sprint 3 (11/28-12/7)

## Forecast

We forecasted we could get **26 story points** done during this sprint.

The forecast correlated to the next three stories from our [Ordered Product Backlog](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#initial-product-backlog-order), with the 'Vision' Page story being introduced based on stakeholder feedback after release1:

| __Number__ | __Title__ | __Story Points__ | __Summary__
| --- | --- | --- | --- |
| 1. | Admin create blog entry | 13 pts | As site owner, I want to post a variety of articles about events, outcomes, and needs so that community members can be inspired and informed. |
| 2. | Admin delete blog entry | 5 pts | As site owner, I want to be able to delete previously created blog entries, so that I can remove older content or modify posts. |
| 3. | Public view blog entries | 8 pts | As a member, I want to view a list of all blog entries, ordered by date, newest to oldest. |

## Actual

We were able to hit our forecasted value in the sprint (reference our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done)).
 
@todo

### Pull Requests

We have created and merged in 15 pull requests in this sprint. An example is here:

![pull request example](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/shawn-pull-request.png)

### Continuous Integration / Continuous Deployment

@todo

#### Git WebHook

Each commit to our master `CommunityTable` repository triggers a jenkins job. 

![jenkins webhook](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/jenkins_webhook.png)

#### Jenkins Jobs

The jobs are configured in Jenkins to inject deployment specific properties, then run `mvn clean install`, then copy the 
resulting WAR file to tomcat.

![jenkins jobs](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/jenkins.png)

#### Jenkins Slackbot

![jenkins webhook](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/jenkins_webhook.png)

### Acceptance Criteria and Sprint Tasks 

1. User Story: _Admin create blog entry_

![Admin create blog entry](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/user-stories-1.png?raw=true)

2. User Story: _Admin delete blog entry_

![Admin delete blog entry_](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/user-stories-2.png?raw=true)

3. User Story: _Public view blog entries_

![Public view blog entries](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/user-stories-3.png?raw=true)

### Behavior-Driven Development & Unit Tests

@todo

## Burndown

Our burndown is based on the completion of each user story's Sprint Task Checklist (shown above) which were decomposed from the PBIs committed to the sprint. The last item is always "Meets Definition of Done" ([ref](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done)). 

Subsequently, our Definition of Done has a checklist item for "Acceptance criteria completed" which corresponds to the specific acceptance criteria of each user story (also shown above).

![Burndown Chart Sprint 3](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/burn-final.png?raw=true)

## Daily Scrums (1-day sample)

#### Michael Johns
_What did you accomplish yesterday?_
> research featured image (open graph), fixed impediment with server javamail sending, setup accounts on stakeholder hosting, merged pull requests

_What will you do today?_
> implement featured image on create blog

#### Kel Doyle
_What did you accomplish yesterday?_
> Implemented deletion confirm message.

_What will you do today?_
> Implementing basic view for displaying blog entry summaries and links to blog details.

#### Paul Laskorski
_What did you accomplish yesterday?_
> Worked will Kel on admin email list. Updated BlogRepository to find individual blog entries by Id, and also to retrieve all blog entries in descending date order. Created BlogController to render views for blog entry summaries and for individual blog entries. Updated unit tests for this work.

_What will you do today?_
> Continue unit testing

#### Shawn Roe
_What did you accomplish yesterday?_
> sprint meeting.

_What will you do today?_
> get the repo working locally again.

_What obstacles are impeding your progress?_
> the repo not working locally

#### Dairai Nyabando

_What will you do today?_
> working on the test cases and blog create validation

#### Melvin Tercan
_What did you accomplish yesterday?_
> - updated burndown chart
> - created and started sprint3.md
> - mob programming with Dairai and Shawn (trying to get summernote to work)

_What will you do today?_
> - online meeting

### Impediments

_IRP = Impediment Removal Plan_

#### Dairai - Dec 4th, 06:27 am
> Understanding why summernote function is not recognised when loading html by jquery

IRP: Sync up with Michael to learn how he did it.

#### Shawn - Dec 5th, 01:06 pm
> understanding of summernote and when the js is loading

IRP: Sync up with Michael to learn how he did it.

#### Shawn - Dec 6th, 12:54 pm
> the repo not working locally

IRP: Solved in Slack.

#### Kel - Dec 8th, 02:03 pm
> ramping up on summernote

IRP: Sync up with Michael to learn how he did it.

## Collaboration
Our Team met as a group at least 2x per week to synchronize and elevate obstacles along our critical path; additionally, individuals teamed up to pair program in order to solve various engineering tasks.  

| __Date__ | __Meeting Type__ |
| --- | --- |
| 29 NOV | Standing Team Meeting |
| 1 DEC | Standing Team Meeting |
| 5 DEC | Standing Team Meeting |
| 8 DEC | Optional Team Meeting |
| 11 DEC | Sprint Review & Retrospective |

1. Example of a peer code review (part of our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done))

@todo

2. Example of a standing team meeting
 
@todo

3. Example of mob programming:

![Mob Programming](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/mob-programming.png?raw=true)

## Sprint Review and Retrospective

We conducted our sprint review with stakeholders and Scrum Team retrospective 11 DEC. 

### Stakeholder Feeback

@todo
 
### Scrum Team Retrospective

@todo
