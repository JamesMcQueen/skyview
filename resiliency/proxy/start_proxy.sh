#!/usr/bin/env bash

# Start Envoy
/usr/local/bin/envoy -c /etc/proxy-envoy.json --service-cluster skyview_proxy --service-node skyview_proxy