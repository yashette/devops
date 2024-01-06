docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube:latest

mvn clean install

mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=admin -Dsonar.password=ece4gmRo!
