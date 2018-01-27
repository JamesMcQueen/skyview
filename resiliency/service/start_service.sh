#!/usr/bin/env bash

# Start Java
java -jar skyview.jar &
envoy -c /etc/service-envoy.yaml --service-cluster service${SERVICE_NAME}
