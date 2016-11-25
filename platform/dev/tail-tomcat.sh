#!/usr/bin/env bash

# e.g. catalina.yyyy-MM-dd.log

DATE=`date +%Y-%m-%d`
FILE="catalina.$DATE.log"

echo "... tailing $FILE "
docker exec -it ct-tomcat bash -c "tail -f -n 10 /usr/local/tomcat/logs/$FILE"