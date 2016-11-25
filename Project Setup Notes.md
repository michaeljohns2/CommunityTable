# Project Setup Notes

This doc describe minimums needed to start work on the project.

## Project Structure

Here is our project architecture.

![Architecture Diagram](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/community%20tables%20architecture.png)

## Spring MVC

In a Spring MVC project, we don't usually reference JSP files directly. We access them through route mappings, which are mapped to a controller.
There are a lot of online tutorials for Spring MVC. We will list pinpointed references here.

## IntelliJ Help

Opening and running the project in IntelliJ

1. Start IntelliJ Idea and select Import Project.
2. Import the project as a Maven project (select the room pom.xml file)
3. If IntelliJ lists warnings about Java 1.5 being obsolete, go to File->Settings->Java Compiler and set bytecode version to 1.8 for Project and Target.
4. Also go to Project Structure->Project Settings-> Modules and change language level from 5 to 8.
5. You should be able to build the project without error.

## Tomcat

### Option-1 (Manual)
One option is to manually drop the WAR file into a Tomcat 8 webapps folder on a local server and run it (tested on Tomcat 8 / Windows 10 machine). To have IntelliJ generate a WAR file on Make go to File->Project Structure->Artifacts and check "Build on Make".

### Option-2 (Docker)
_Reference 'Local Platform Development (Docker)' section below._

### Option -3 (PROBLEMMATIC AFTER RELEASE-1)
Another option is to run the provided pom plugin `mvn tomcat7:run` (you can set this up as a run config in your IDE or run from the command line).Note: this mvn command works with Tomcat 7 and 8 (we are using 8); it uses the embedded Tomcat jars configured in the pom. These instructions were adapted from this [blog post](http://viralpatel.net/blogs/embed-tomcat-maven-project-run-tomcat-maven/).

Here is an example of adding a mvn tomcat run configuration to IntelliJ:
  
![IntelliJ Settings](https://github.com/michaeljohns2/CommunityTable/blob/master/readme/mvn_tomcat_plugin.png)

More in-depth plugin settings can be found [here](http://tomcat.apache.org/maven-plugin-trunk/tomcat7-maven-plugin/run-mojo.html).

## Local Platform Development 

__Note: For email support in either option, follow instructions in section _'Email Settings (Local Development)'_ below. If you have the SMTP settings in your `Server_Custom.properties` then they will be applied when you package for Tomcat.__

### Option-1: For Docker 

__Note: Support throw-away instances for both Mongo and Tomcat -- this assumes a *NIX environment with bash and Docker.__

Starting with release-2, dev support to run throw-away mongo and tomcat available in [platform dev](https://github.com/michaeljohns2/CommunityTable/blob/master/platform/dev).
To use `cd platform/dev` and run any of the following:

* Start: `./start-all.sh` for both mongo and tomcat or `make start-mongo` for only mongo or `make start-tomcat` for only tomcat. 
  * _This command will internally run `mvn clean package` on the project and copy the resulting war file into the container's `webapps` directory, thus eliminating any manual build and deploy steps._
  * Optional: watch the tomcat logs with `tail-tomcat.sh` (you provide todays date as arg1 to watch the current log, e.g. `tail-tomcat.sh 2016-11-20`)
* Stop: `stop-all.sh` to stop and remove mongo and tomcat.
* Other `make` commands can be run if desired.

### Option-2: For Manual 

If you are not running via the Docker throw-away instance scripts,  you  will need to install the following on your local machine:

* Tomcat 8.5.8 -- start Tomcat with `<path to tomcat>/bin/catalina.sh start`
* Mongo 3.2 or 3.3 -- start Mongo with `<path to mongo>/bin/mongod`. 

To run CommunityTable webapp, from project root:

1. `cd WebApp`
2. `mvn clean package` to generate the war file
3. `cp -rf target/CommuntyTables.war <path to tomcat>/webapps`
4. you may need to restart Tomcat (`<path to tomcat>/bin/catalina.sh stop` followed by `<path to tomcat>/bin/catalina.sh stop`)
5. The app will be available at `http://localhost:8080/CommunityTables/index.html`

## Server.properties

Server properties used by the app are found in  `WebApp/src/resources/Server.properties`. The default values are something like the following:

* mongo.server=Mongo
* db.name = CommunityTables
* db.port = 27017
* host.path=http://localhost/
* smtp.host=my.smtp.host
* smtp.port=25
* smtp.user=user
* smtp.user.password=password
* smtp.start.ttls=false

Developers can locally supply `Server_Custom.properties` with any override values (especially sensitive ones like user and password), just 
generate the file in `WebApp/src/resources` and populate as needed.  __Note: `Server_Custom.properties` is ignored by .gitignore and should
never be committed to the repository.__

`ConfigManager` class (in `com.community.utils`) is a singleton which allows a seemless access to properties. It will first attempt to find a 
given key in `Server_Custom` and if found will use its value; if not, it will use the default value from `Server`. 
E.g. usage: `ConfigManager.getInstance().getSetting(ConfigManager.MONGO_SERVER_KEY);` or `ConfigManager.getInstance().getSettingAsInt(ConfigManager.DB_PORT_KEY);`

### Email Settings (Local Development)
For local development and testing, it is recommended to generate a `WebApp/src/resources/Server_Custom.properties` and place the following properties:

#### Option-1: For Incubation Site SMTP

* `smtp.host=community-tables.vinodhalaharvi.com`
* `smtp.port=587`
* `smtp.user=<your slack username>`
* `smtp.user.password=<your password>`
* `smtp.start.ttls=true`

__Note: Each member of the CommunityTables team already has an account on our incubation site.__
The initial password is `updateyourpassword`. The first time you log in, you will need to change your password. To accomplish this execute the following command:
`ssh -l <your slack username> <incubation server ip>` (then provide you password on the prompt and then you can exit) -- once this is accomplished, sending will be handled by our incubation site for local development.

#### Option-2: For Gmail SMTP

* `smtp.host=smtp.gmail.com`
* `smtp.port=587`
* `smtp.user=<your gmail email>`
* `smtp.user.password=<your password>`
* `smtp.start.ttls=true`

__Note: To use gmail SMTP you may need to go to https://www.google.com/settings/security/lesssecureapps?rfn=27&rfnc=1&et=0&asae=2&anexp=ire-control and temporarily allow less secure connections first.__

## Messages.properties
Similar to Server above, messages are pulled from `Messages.properties`, with support from `MessageManager`. Unlike `ConfigManager`, there are no overrides.

## Testing 
When running tests, an existing `target/tomcat` folder may need to be deleted to avoid conflicts with the mock/fake mongo (fongo) and tomcat testing. BDD / A-TDD Tests are handled by Cucumber (plugin for IntelliJ used). Unit Tests are with JUnit.

## Deployment 
* We are implementing CI/CD so that a check-in to master triggers Jenkins to redeploy on our AWS incubation site.
 * Contact team members for instructions on accessing our AWS incubation resources.

