#!/usr/bin/env bash
envoy -c /etc/${SERVICE_NAME}-envoy.yaml --service-cluster ${SERVICE_NAME}
