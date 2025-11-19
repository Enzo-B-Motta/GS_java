FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY . ./

RUN chmod +x mvnw
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -Dskip    Tests clean dependency:list install

CMD ["sh", "-c", "java -jar target/Clientes-0.0.1-SNAPSHOT.jar"]