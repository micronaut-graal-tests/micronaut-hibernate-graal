./gradlew assemble
native-image --no-server --class-path build/libs/hibernate-graal-0.1.jar
