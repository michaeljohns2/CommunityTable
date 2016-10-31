# Vinod Halaharvi (vinod.halaharvi@gmail.com)
# Community Tables Project

SHELL := /bin/bash
all: start-mongodb start-tomcat start-jenkins start-nginx

docker-remove-all:
	docker rm $(docker ps -a -q)

docker-kill-all:
	docker kill $(docker ps -q)

restart-tomcat: kill-tomcat start-tomcat

restart-jenkins: kill-jenkins start-jenkins

restart-mongodb: kill-mongodb start-mongodb

restart-nginx: kill-nginx start-nginx

kill-tomcat:
	docker stop `docker ps -a -q --filter="name=ct-tomcat"`
	docker rm -f `docker ps -a -q --filter="name=ct-tomcat"`

kill-nginx:
	docker stop `docker ps -a -q --filter="name=ct-nginx"`
	docker rm -f `docker ps -a -q --filter="name=ct-nginx"`

kill-mongodb:
	docker stop `docker ps -a -q --filter="name=ct-mongodb"`
	docker rm -f `docker ps -a -q --filter="name=ct-mongodb"`

kill-jenkins:
	docker stop `docker ps -a -q --filter="name=ct-jenkins"`
	docker rm -f `docker ps -a -q --filter="name=ct-jenkins"`

start-jenkins:
	if [ ! -a /var/jenkins_home ] ; then  mkdir -p /var/jenkins_home; fi
	docker run -itd \
		--name ct-jenkins \
		--network=ct-network  \
		-h jenkins \
		-p 8081:8080 \
		-p 50000:50000 \
		-u root \
		-v /var/jenkins_home:/var/jenkins_home jenkins

start-mongodb:
	if [ ! -a /usr/local/mongodb/data ]; then mkdir -p /usr/local/mongodb/data; fi
	docker run \
		--name ct-mongo \
		--network=ct-network \
		-h mongodb \
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
		--link=ct-mongodb:mongodb \
		-d  \
		-v /usr/local/tomcat/lib:/usr/local/tomcat/lib \
		-p 8080:8080 tomcat:8.0
