# Welcome to Livefox WebApp!

Please use this instructions as a guide to understand and deploy this webapp based on microservices infrastructure


# Microservices

 - Config-server
 - Eureka-server
 - Zuul-server
 - SpringAdmin-server
 - Microservice video
 - ClientUI

## Install and Run

**You have to run in this order because they all depend on Config-server and Eureka-server**

Normally all **.jar** files are in ../target/*.jar
All docker images are available in [Docker Hub ](https://hub.docker.com/)

You can use the docker-compose in the root directory as follow:

    docker-compose up


## Setup Kubernetes

You can follow [this](https://github.com/bastienbosser/raspberry_project)  Kubernetes instructions to install it on Raspberry pies

## Deploy

You can add [this](https://github.com/NeopixNG/livefox) files to deploy in your kubernetes cluster