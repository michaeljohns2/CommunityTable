#!/usr/bin/env bash

# e.g. catalina.yyyy-MM-dd.log

FILE="catalina.$1.log"

echo "expects arg1 with yyyy-MM-dd"
echo "... tailing $FILE "
docker exec -it ct-tomcat bash -c "tail -f -n 10 /usr/local/tomcat/logs/$FILE"