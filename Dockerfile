FROM envoyproxy/envoy:latest

VOLUME /tmp
ADD ./build/libs/skyview-0.1.0.jar skyview.jar

ENV DEBIAN_FRONTEND noninteractive

#Install Operating System, Java and Additional Dependencies
RUN  apt-get update \
  && apt-get install -y \
  software-properties-common \
  curl \
  openjdk-8-jdk \
  && rm -rf /var/lib/apt/lists/*cat

CMD java -jar skyview.jar