FROM oracle/graalvm-ce:1.0.0-rc13 as graalvm
COPY . /home/app/hibernate
WORKDIR /home/app/hibernate
RUN native-image --no-server -cp build/libs/hibernate-*.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/hibernate .
ENTRYPOINT ["./hibernate"]
