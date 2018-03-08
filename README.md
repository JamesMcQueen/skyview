# Skyview
<i>A real-time weather preview of the sky.
Providing basic weather reports for various airport locations.</i>

### Setup of Application
- Documentation for how to use Envoy is located at: https://www.envoyproxy.io/docs/envoy/latest
- Envoy is part of the Service Mesh POC: https://confluence/display/BCPI/Service+Mesh+for+Gaia+POC
- Documentation specific to this application is located at: https://confluence/display/BCPI/Envoy+POC
- In order to use the Weather Report API you'll need to obtain an API_KEY from: https://openweathermap.org/api
- Once you have an API key you can replace the YOUR_API_KEY_HERE entry inside the application-example.yaml file
and rename the file to application.yml

### Configurations
Currently Envoy is used from 4 different configuration files
- proxy-envoy.yml: Contains the entry point for upstream services, points to other hosts within the local_proxy cluster.
- filtered-envoy.yml: Contains abort fault filter used to "blackhole" requests, returns a user provided http status code for example 532.
- slow-envoy.yml: Contains delay fault filter used to slow the response to requests made to this host.
- service-envoy.yml: Contains setup for a "healthy" service, in other words no faults are introduced here.


### Currently Implemented
* Abort Http Fault Filter: Aborts requests to specific service configured via http_filters: key in .yml config
* Delay Http Fault Filter: Delays requests given an amount of time to wait and a percentage of requests.
* Retry at a per cluster level: Retries requests given a set of circumstances such as 5xx or gateway-timeout.
* Circuit Breakers: Implemented but not fully tested for functional / expected divergence.