#!/usr/bin/env bash

java -jar skyview.jar &
envoy -c /etc/service-envoy.yaml --service-cluster service${SERVICE_NAME}
