# Welcome to Livefox WebApp!



![rasp](https://raw.githubusercontent.com/iiiypuk/rpi-icon/master/256.png) ![enter image description here](https://laurent-dechoux.fr/static/img/kub_256.33b292b.png)


Please use this instructions as a guide to understand and deploy this webapp based on microservices infrastructure


# Microservices

 - MySQL-server
 - Microservice video
 - ClientUI
 

## Description MySQL-server
Use as a MySQL database, this Docker image build and fill the livefoxdb with data

 - port:3306
 - Docker image :[livefox/mysql](https://hub.docker.com/repository/docker/livefox/mysql)

## Description Microservice Video
Use to fetch video's data in the MYSQL database

- app name: microservice-video 
 - port: 9001
 - Docker image: [livefox/mvideo-client](https://hub.docker.com/repository/docker/livefox/mvideo-client)

## Description Microservice Upload
Use to upload file in the shared volume inside kubernetes

 - port:9002
 - Docker image :[livefox/mupload-client](https://hub.docker.com/repository/docker/livefox/mupload-client)

## Description Microservice Player
Use to read MP4 Files in the shared volume

- app name: microservice-video 
 - port: 9003
 - Docker image: [livefox/mplayer-client](https://hub.docker.com/repository/docker/livefox/mplayer-client)

## Description ClientUI
Use to display Application microservices like Mvideo, Display alos the HomePage

- app name: clientui 
 - port: 8080
 - Docker image: [livefox/clientui-client](https://hub.docker.com/repository/docker/livefox/clientui-client)




# Install and Run

Normally all **.jar** files are in ../target/*.jar
All docker images are available in [Docker Hub ](https://hub.docker.com/)


To build a Cluster, you can use [Kind](https://kind.sigs.k8s.io/docs/user/quick-start/) or [MiniKube](https://kubernetes.io/fr/docs/setup/learning-environment/minikube/)

Then you can use the deployment.yaml file in root directory:

    kubectl apply -f deployment.yaml

That's it, Enjoy !
