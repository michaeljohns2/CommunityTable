## Sprint 1 (10/8-11/11)

### Forecast

Based on the fact that we all still needed to configure the project and get it running on our localhost before we were able to begin work on the stories that actually delivered product value, we forecasted we could get **21 story points** done during this sprint.

### Actual

We were able to close on all user stories forecasted within the sprint (reference our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/sprint0.md)). A summary of release1 is given in the [Main Readme](https://github.com/michaeljohns2/CommunityTable/blob/master/README.md).
Our stakeholders and Scrum Team agree that while release1 is feature complete under sprint1 scope, we not attempt to deploy into public production until further protections of Mongo and email services are completed -- these are captured as PBIs and are prioritized for sprint2.

### Burndown

![Burndown Chart Sprint 1](https://image-charts.com/chart?cht=lc&chd=t:21.00,18.67,16.33,14.00,11.67,9.33,7.00,4.67,2.33,0.00|21.00,21.00,21.00,20.42,20.42,14.00,11.67,10.50,8.17,4.67&chco=2196F3,FF5722&chxt=x,y&chxl=0:|1|2|3|4|5|6|7|8|9|10|&chs=600x200&chtt=Burndown%20Chart%20Sprint%201&chg=20,0,1,3)

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

### Collaboration
Our Team met as a group at least 2x per week to synchronize and elevate obstacles along our critical path; additionally, individuals teamed up to pair program in order to solve various engineering tasks.  

| __Date__ | __Meeting Type__ |
| --- | --- |
| 03 NOV | Standing Team Meeting |
| 07 NOV | Standing Team Meeting |
| 10 NOV | Standing Team Meeting |
| 13 NOV | Sprint Review & Retrospective |

1. Example of a peer code review (part of our [Definition of Done](https://github.com/michaeljohns2/CommunityTable/blob/master/sprint0.md))

 ![Code Review](https://github.com/michaeljohns2/CommunityTable/blob/master/code_review.png)

2. Example of an ad-hoc team meeting

 ![Ad-Hoc Team Meeting](https://github.com/michaeljohns2/CommunityTable/blob/master/team_huddle.png)

3. Example of a standing team meeting
 
 ![Standing Team Meeting](https://github.com/michaeljohns2/CommunityTable/blob/master/Pasted%20image%20at%202016_11_07%2007_33%20PM.png)
