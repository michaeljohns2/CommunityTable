# Vinod Halaharvi (vinod.halaharvi@gmail.com)
# Community Tables Project

SHELL := /bin/bash
all: start-mongo start-tomcat start-jenkins start-nginx

docker-remove-all:
	docker rm $(docker ps -a -q)

docker-kill-all:
	docker kill $(docker ps -q)

restart-tomcat: kill-tomcat start-tomcat

restart-jenkins: kill-jenkins start-jenkins

restart-mongo: kill-mongo start-mongo

restart-nginx: kill-nginx start-nginx

restart-email: kill-email start-email

kill-tomcat:
	docker stop `docker ps -a -q --filter="name=ct-tomcat"`
	docker rm -f `docker ps -a -q --filter="name=ct-tomcat"`

kill-nginx:
	docker stop `docker ps -a -q --filter="name=ct-nginx"`
	docker rm -f `docker ps -a -q --filter="name=ct-nginx"`

kill-mongo:
	docker stop `docker ps -a -q --filter="name=ct-mongo"`
	docker rm -f `docker ps -a -q --filter="name=ct-mongo"`

kill-jenkins:
	docker stop `docker ps -a -q --filter="name=ct-jenkins"`
	docker rm -f `docker ps -a -q --filter="name=ct-jenkins"`

kill-email:
	docker stop `docker ps -a -q --filter="name=ct-email"`
	docker rm -f `docker ps -a -q --filter="name=ct-email"`


start-jenkins:
	if [ ! -a /var/jenkins_home ] ; then  mkdir -p /var/jenkins_home; fi
	docker run -itd \
		--name ct-jenkins \
		--network=ct-network  \
		-h jenkins \
		-p 8081:8080 \
		-p 50000:50000 \
		-u root \
		-v /root/CommunityTable/:/root/CommunityTable/ \
		-v /usr/local/tomcat/webapps:/usr/local/tomcat/webapps \
		-v /var/jenkins_home:/var/jenkins_home vhalaharvi/jenkins-make-mvn

start-email:
	if [ ! -a /var/email_home ] ; then  mkdir -p /var/email_home; fi
	 sudo docker run -itd -p 25:25 \
		--name ct-email \
		--network=ct-network  \
		--link=ct-mongo:mongo \
		-itd ubuntu bash

test-deleteme:
	docker run -itd \
		--name ct-email \
		--network=ct-network  \
		--link=ct-mongo:mongo \
		-e RELAY_NETWORKS=10.0.0.0/16 \
		-e MAILNAME=communitytable.com \
		-h email \
		-u root \
		-v /var/email_home:/var/email_home

start-mongo:
	if [ ! -a /usr/local/mongodb/data ]; then mkdir -p /usr/local/mongodb/data; fi
	docker run \
		--name ct-mongo \
		--network=ct-network \
		-h mongo \
		-p 27017:27017 \
		-d \
		-v /usr/local/mongodb/data:/data/db \
		-d mongo:latest

start-nginx:
	if [ ! -a /etc/nginx ]; then  mkdir -p /etc/nginx; fi
	docker run -itd \
		--name ct-nginx \
		--network=ct-network \
		-h nginx \
		-p 80:80 \
		-v /etc/nginx/conf.d:/etc/nginx/conf.d nginx

start-tomcat:
	if [ ! -a /usr/local/tomcat/lib ]; then  mkdir -p /usr/local/tomcat/lib; fi
	docker run \
		--name=ct-tomcat \
		--network=ct-network -h tomcat \
		--link=ct-mongo:mongo \
		-d  \
		-v /usr/local/tomcat/logs:/usr/local/tomcat/logs \
		-v /usr/local/tomcat/lib:/usr/local/tomcat/lib \
		-v /usr/local/tomcat/conf:/usr/local/tomcat/conf \
		-v /usr/local/tomcat/webapps:/usr/local/tomcat/webapps \
		-p 8080:8080 tomcat:8.0


# test suite

restart-tomcat-test: kill-tomcat-test start-tomcat-test

kill-tomcat-test:
	docker stop `docker ps -a -q --filter="name=ct-tomcat-test"`
	docker rm -f `docker ps -a -q --filter="name=ct-tomcat-test"`

start-tomcat-test:
	if [ ! -a /usr/local/tomcat/lib ]; then  mkdir -p /usr/local/tomcat/lib; fi
	docker run \
		--name=ct-tomcat-test \
		--network=ct-network -h tomcat \
		--link=ct-mongo:mongo \
		-it  \
		-v /usr/local/tomcat/logs:/usr/local/tomcat/logs \
		-v /usr/local/tomcat/lib:/usr/local/tomcat/lib \
		-v /usr/local/tomcat/conf:/usr/local/tomcat/conf \
		-v /usr/local/tomcat/webapps:/usr/local/tomcat/webapps \
		tomcat:8.0 bash

# deployment
deploy:
	cd /root/CommunityTable/ && \
	git pull &&  \
	cd /root/CommunityTable/WebApp/ && \
		mvn clean install && \
		cp /root/CommunityTable/WebApp/target/CommunityTables.war /usr/local/tomcat/webapps/  && \
		cd /root/CommunityTable/platform/ && make restart-tomcat

