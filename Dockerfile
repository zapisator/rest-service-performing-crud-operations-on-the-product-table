FROM openjdk:11

COPY build/libs/*SNAPSHOT.jar /deployments/app.jar

ENTRYPOINT exec java $JAVA_OPTS $OPTIONS -jar /deployments/app.jar