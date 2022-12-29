FROM gradle:7.6.0-jdk11 as gradleimage

COPY . /home/gradle/src

WORKDIR /home/gradle/src
RUN gradle init
RUN gradle build --no-daemon 

FROM gradle:7.6.0-jdk11 

EXPOSE 8080

RUN mkdir /app

COPY --from=gradleimage /home/gradle/src/build/libs/*.jar /app/group-11-offics-desk-booking-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app/group-11-offics-desk-booking-0.0.1-SNAPSHOT.jar"]