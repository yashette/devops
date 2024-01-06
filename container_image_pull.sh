docker login -u yashette -p glpat-weW4bwGUHS2UNts7zBt7 registry.gitlab.com

docker pull registry.gitlab.com/max9933701/springboot/devops:latest

docker run -d --name conteneur -p 8080:80 registry.gitlab.com/max9933701/springboot/devops:latest