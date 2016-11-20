#!/usr/bin/env bash

# make sure network is created
echo ""
echo "...ensuring 'ct-network' is available (error is normal if already exists)"
echo ""
docker network create -d bridge ct-network
echo ""
echo "...running start-all ('make all')"
echo ""
make all
echo "...up and running! (kill with 'stop-all-docker.sh')"