# use openjdk 8 image as base image
FROM openjdk:8

# add jar file into the docker container - copy the jar file and add that to the root of the container
# ADD /target/docker-spring.jar /jar/docker-spring.jar - copy and add to the container's root/jar location
ADD /target/docker-spring.jar docker-spring.jar

EXPOSE 8081

# instruction used to configure how the container will run.
ENTRYPOINT ["java","-jar","docker-spring.jar"]
