#!/usr/bin/env bash

echo "Checking if hub is ready - $HUB_HOST"

while [[ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready)" != "true" ]]; do
    sleep 1
  done

java -cp selenium-docker-tests.jar:selenium-docker.jar:libs/* \
     -DHUB_HOST=$HUB_HOST \
     -DBROWSER=$DBROWSER \
     org.testng.TestNG $MODULE

