mvn clean
mvn flyway:migrate
mvn package
mvn dependency:copy-dependencies
java -cp .:target/*: net.greet.Greeter
