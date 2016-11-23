# Michael Johns (michael.johns2@gmail.com)
# Local Development (adapted from the platform Makefile)
# Community Tables Project

# !!! IF YOU EDIT THIS BE CAREFUL OF HIDDEN CHARS !!!

SHELL := /bin/bash

# use CURDIR (built-in) instead of $(pwd)
$(info CURDIR is ${CURDIR})

# determine parent dir from CURDIR (using shell)
PARDIR := $(shell dirname ${CURDIR})
$(info PARDIR is ${PARDIR})

all: start-mongo start-tomcat

docker-remove-all:
	docker rm $(docker ps -a -q)

docker-kill-all:
	docker kill $(docker ps -q)

restart-tomcat: kill-tomcat start-tomcat

restart-mongo: kill-mongo start-mongo

kill-tomcat:
	docker stop `docker ps -a -q --filter="name=ct-tomcat"`
	docker rm -f `docker ps -a -q --filter="name=ct-tomcat"`

kill-mongo:
	docker stop `docker ps -a -q --filter="name=ct-mongo"`
	docker rm -f `docker ps -a -q --filter="name=ct-mongo"`

start-mongo:
	#--------------------------------------------------
	# <<< START MONGO >>>
	# !!! NO PERSISTENCE HERE FOR LOCAL DEV !!!
	#--------------------------------------------------

	docker run \
		--name ct-mongo \
		--network=ct-network \
		-h mongo \
		-d \
		-p 27017:27017 mongo:latest

start-tomcat:
	#-------------------------------------------------
	# <<< START TOMCAT >>>
	# tomcat 8.0 uses jre7 by default, 8.5 uses jre8
	# !!!EXPECTS MONGO STARTED ALREADY!!!
	#--------------------------------------------------

	# (1) ensure host volumes for tomcat8 are available
	if [ ! -a ${CURDIR}/tomcat8/webapps ]; then mkdir -p ${CURDIR}/tomcat8/webapps; fi

	# (2) run mvn package to generate a new WAR (also clear any stale libs)
	cd ../../WebApp && mvn clean package

	# (3) copy latest WAR into webapps
	cp ../../WebApp/target/CommunityTables.war tomcat8/webapps/CommunityTables.war

	# (4) run docker
	docker run \
		--name=ct-tomcat \
		--network=ct-network -h tomcat \
		--link=ct-mongo:mongo \
		-d \
		-v ${CURDIR}/tomcat8/webapps:/usr/local/tomcat/webapps \
		-p 8080:8080 tomcat:8.5
