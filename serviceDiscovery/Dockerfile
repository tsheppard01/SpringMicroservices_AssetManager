FROM openjdk:11.0.8 as build
WORKDIR /workspace/app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} target/app.jar
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../app.jar)

FROM openjdk:11.0.8
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.tsheppard01.assetmanager.servicediscovery.ServiceDiscovery"]
