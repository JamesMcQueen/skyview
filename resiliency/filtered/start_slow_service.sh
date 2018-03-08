#!/usr/bin/env bash

java -jar skyview.jar &
envoy -c /etc/slow-envoy.yaml --service-cluster ${SERVICE_NAME}