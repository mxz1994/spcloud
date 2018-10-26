mvn clean package docker:build

docker build -t 仓库名称/镜像名称


docker run -d -p 8761:8761 仓库名/镜像名