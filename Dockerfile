FROM nimmis/java-centos:openjdk-8-jdk

VOLUME /tmp
ADD ./build/libs/skyview-0.1.0.jar skyview.jar
CMD java -jar skyview.jar