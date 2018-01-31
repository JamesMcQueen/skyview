FROM envoyproxy/envoy:latest

VOLUME /tmp
ADD ./build/libs/skyview-0.1.0.jar skyview.jar
COPY ./resiliency/service/service-envoy.yaml ./etc/service-envoy.yaml
COPY ./resiliency/service/start_service.sh .

ENV DEBIAN_FRONTEND noninteractive

#Install Operating System, Java and Additional Dependencies
RUN  apt-get update \
  && apt-get install -y \
  software-properties-common \
  curl \
  openjdk-8-jdk \
  && rm -rf /var/lib/apt/lists/*

RUN chmod +x start_service.sh

ENTRYPOINT ["./start_service.sh"]