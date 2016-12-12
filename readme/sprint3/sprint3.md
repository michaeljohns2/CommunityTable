# Sprint 3 (11/28-12/7)

## Forecast

Using Yesterday's Weather Pattern, we forecasted we could commit to **26 story points** during this sprint.
This forecast is up 10 points from our Sprint-2 forecast, which was affected by team member Thanksgiving Holiday plans and up 5 points from our Sprint-1 forecast. 
We were confident that our now evolved team would be able to hit this increased velocity through tight communication, use of our CI/CD processes, 
and generally increased comfort level with the project goals, skill mix, and technology applied. 

The forecast correlated to the next three stories from our [Ordered Product Backlog](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#initial-product-backlog-order), with the 'Vision' Page story being introduced based on stakeholder feedback after release1:

| __Number__ | __Title__ | __Story Points__ | __Summary__
| --- | --- | --- | --- |
| 1. | Admin create blog entry | 13 pts | As site owner, I want to post a variety of articles about events, outcomes, and needs so that community members can be inspired and informed. |
| 2. | Admin delete blog entry | 5 pts | As site owner, I want to be able to delete previously created blog entries, so that I can remove older content or modify posts. |
| 3. | Public view blog entries | 8 pts | As a member, I want to view a list of all blog entries, ordered by date, newest to oldest. |

## Actual

We were able to hit our forecasted value in the sprint. A summary of [release3](https://github.com/michaeljohns2/CommunityTable/blob/master/README.md#release-3-notes) is is given in the main readme.

### Pull Requests

We created and merged in 15 pull requests in this sprint. Here is an example of a pull request:

![pull request example](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/shawn-pull-request.png)

### Continuous Integration / Continuous Deployment

We continued to use and refine our [CI/CD process](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint2/sprint2.md#continuous-integration--continuous-deployment) fully adopted in Sprint-2.

### Acceptance Criteria and Sprint Tasks 

1. User Story: _Admin create blog entry_

 ![Admin create blog entry](https://raw.githubusercontent.com/michaeljohns2/CommunityTable/master/readme/sprint3/user-story-1.png?raw=true)

2. User Story: _Admin delete blog entry_

 ![Admin delete blog entry_](https://raw.githubusercontent.com/michaeljohns2/CommunityTable/master/readme/sprint3/user-story-2.png?raw=true)

3. User Story: _Public view blog entries_

 ![Public view blog entries](https://raw.githubusercontent.com/michaeljohns2/CommunityTable/master/readme/sprint3/user-story-3.png?raw=true)

### Behavior-Driven Development & Unit Tests

We used Cucumber to add a new BDD test the blog create and list functions managed by [AdminController](https://github.com/michaeljohns2/CommunityTable/blob/master/WebApp/src/main/java/com/community/controller/AdminController.java).
The feature exercises the sorting for display and preview function when listing blogs.

![cucumber test](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/cucumber_test.png)

We also increased out unit tests to 37, bringing the project to 64% class and 48% of line coverage. While we always aim for maximum coverage,
our primary focus is on core business logic, allowing more trivial plumbing and object classes to have lower coverage.

![unit tests](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/unit_tests_coverage.png)

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

1. Example of a standing team meeting
 
 ![Standing Team Meeting](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/team_meeting_20161205.png?raw=true)

2. Example of peer programming (part of our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint0/sprint0.md#definition-of-done)):

 ![Mob Programming](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/sprint3/mob-programming.png?raw=true)

## Sprint Review and Retrospective

We conducted our sprint review with stakeholders and Scrum Team retrospective 11 DEC. 

### Stakeholder Feeback

Stakeholder was pleased with the progress made in Sprint-3 and the simplicity of use of the new blog features. She offered the following feedback:

* Images with text inline would be useful in the future
* Maybe more beefy blog support (either developed or a service such as WordPress) in the future but she anticipates the feature meeting her needs in the near-term to mid-term
 
### Scrum Team Retrospective

We conducted a plus-delta retrospective. The first item listed in the delta's is the one we will carry forward to implement in Sprint-4.

#### Plus

* This was universally agreed to be our best sprint, we hit the ground running more quickly than in the past
* No technical debt - stories were completed, we again hit our marks due to team communication and participation
* Skill mix of team continues to payoff where various members can jump in to contribute when needed
* Separating committed stories into separate channels (#1 retrospective item from Sprint-2) was helpful to allow deeper communication without so much cross-chatter
* We used an impediment board for the first time with success


#### Delta

* Turn up the good: the impediment board should be more heavily used going forward (we will implement this in Sprint-4)
* Team members regret not committing sooner to rigorously learning the technology in use for the project; whereas earlier in the sprints 
those who only worked front-end could avoid most of local environment for Mongo and Tomcat, later sprints including this one put a squeeze on them to really understand in order to support
* Standup participation was incomplete for some this sprint; they recognize that they as well as the team suffers without full use of that vital tool for a healthy scrum team
