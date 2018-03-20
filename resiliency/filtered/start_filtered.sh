#!/usr/bin/env bash

java -jar skyview.jar &
envoy -c /etc/${SERVICE_NAME}-envoy.yaml --service-cluster ${SERVICE_NAME}
