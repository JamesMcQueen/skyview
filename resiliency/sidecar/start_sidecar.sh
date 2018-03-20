#!/usr/bin/env bash

#java -jar skyview.jar &
envoy -c /etc/sidecar-envoy.yaml --service-cluster ${SERVICE_NAME}
