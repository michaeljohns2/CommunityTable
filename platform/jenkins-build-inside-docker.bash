cd /tmp/CommunityTable/ && \
git pull &&
cd /tmp/CommunityTable/WebApp/ && \
mvn clean install && \
cp /tmp/CommunityTable/WebApp/target/CommunityTables.war /usr/local/tomcat/webapps/  &&
cd /tmp/CommunityTable/platform/ && make restart-tomcat
