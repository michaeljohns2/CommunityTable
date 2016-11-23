#!/usr/bin/env bash

# don't stop on errors
set +e

echo ""
echo "...running stop-all ('make kill-tomcat kill-mongo')"
echo ""
make kill-tomcat
make kill-mongo
echo "...all stopped (errors are expected if the container wasn't running)!"