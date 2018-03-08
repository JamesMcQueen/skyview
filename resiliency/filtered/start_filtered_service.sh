#!/usr/bin/env bash

java -jar skyview.jar &
envoy -c /etc/filtered-envoy.yaml --service-cluster ${SERVICE_NAME}
