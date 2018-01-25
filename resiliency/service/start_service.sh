#!/usr/bin/env bash

# Start Envoy
/usr/local/bin/envoy -c /etc/service-envoy.json --service-cluster skyview_service --service-node skyview_service

