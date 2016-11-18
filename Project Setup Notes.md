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
5. To have IntelliJ generate a WAR file on Make go to File->Project Structure->Artifacts and check "Build on Make".
6. You should be able to build the project without error.
7. Tomcat
  option-1: Drop the WAR file into a Tomcat 8 webapps folder on a local server and run it (tested on Tomcat 8 / Windows 10 machine).
  option-2: run the provided plugin `mvn tomcat7:run` (you can set this up as a run config in your IDE or run from the command line)
            Note: this mvn command works with Tomcat 7 and 8 (we are using 8); it uses the embedded Tomcat jars configured in the pom

NOTE: The WAR file that IntelliJ generates may not run on AWS instance (due to java 8 issues).
However, you can build the WAR running command line "mvn clean install", which does work on AWS.

TEST NOTE: When running tests, any existing 'tomcat' folder in the 'target' folder may need to be deleted to avoid
           conflicts with the mock/fake mongo (fongo) and tomcat testing.

## Mongo

Setting Up and Running Mongo in Docker (throw away instances)
If you have docker locally, you can run the following commands:
host (launch container) --> `docker run --rm -it -p 27017:27017 -h mongo --name test_mongo mongo:latest bash -c mongod`
host (get container ip address) --> `docker inspect test_mongo | grep IPAddress`
host (edit hosts file) --> add `<container_ip> Mongo` to /etc/hosts
container (kill processing, this will erase data) --> `Ctrl+C` to stop mongod and exit the container

## Server.properties

Server properties used by the app are found in  `WebApp/src/resources/Server.properties`. The default values are something like the following:

* mongo.server=Mongo
* db.name = CommunityTables
* db.port = 27017
* host.path=http://localhost/
* smtp.host=smtp.gmail.com
* smtp.user=user
* smtp.user.password=password

Developers can locally supply `Server_Custom.properties` with any override values (especially sensitive ones like user and password), just 
generate the file in `WebApp/src/resources` and populate as needed.  __Note: `Server_Custom.properties` is ignored by .gitignore and should
never be committed to the repository.__

`ConfigManager` class (in `com.community.utils`) is a singleton which allows a seemless access to properties. It will first attempt to find a 
given key in `Server_Custom` and if found will use its value; if not, it will use the default value from `Server`. 
E.g. usage: `ConfigManager.getInstance().getSetting(ConfigManager.MONGO_SERVER_KEY);` or `ConfigManager.getInstance().getSettingAsInt(ConfigManager.DB_PORT_KEY);`

## Messages.properties

Similar to Server above, messages are pulled from `Messages.properties`, with support from `MessageManager`. Unlike `ConfigManager`, there are no overrides.