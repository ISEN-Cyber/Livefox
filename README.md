# LIVEFOX
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=NeopixNG_livefox&metric=alert_status)](https://sonarcloud.io/dashboard?id=NeopixNG_livefox)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=NeopixNG_livefox&metric=security_rating)](https://sonarcloud.io/dashboard?id=NeopixNG_livefox)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=NeopixNG_livefox&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=NeopixNG_livefox)

The goal of these resources is to deploy a simple frontend template that will display our uploaded and encoded videos thanks to several frameworks. This template was made with Bootstrap 4.

To launch the deployment, service, persistent volume and persistentVolumeClaim, use this command:

    kubectl apply -f <NomDuFichier.yaml>
    (all the resources are in the cluster folder)
    
To have a simple cluster exposed with an external IP, use the same command with the following file:

    kubectl apply -f config.yaml
    -> using this file, enter neopix/litev2 if your cluster runs an amd64 or neopix/litearmv3 on arm architecture
    -> replace external IP with the master IP!
