[[ ! -a /usr/local/tomcat ]] && mkdir -p /usr/local/tomcat 
docker run --name=ct-tomcat --network=ct-network -h tomcat --link=ct-mongodb:mongodb -d  -v /usr/local/tomcat/lib:/usr/local/tomcat/lib -p 8080:8080 tomcat:8.0
