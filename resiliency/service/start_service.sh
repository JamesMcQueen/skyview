#!/usr/bin/env bash

# Start Envoy
/usr/local/bin/envoy -c /etc/service-envoy.json --service-cluster ${SERVICE_NAME} --service-node skyview_service

#/usr/local/bin/envoy -c /etc/service-envoy.yml --service-cluster ${SERVICE_NAME} --service-node skyview_service