#!/bin/bash

kubectl apply -f https://raw.githubusercontent.com/ISEN-Livefox/Livefox/bastien/configuration_file/nginx/mandatory.yaml
kubectl apply -f https://raw.githubusercontent.com/ISEN-Livefox/Livefox/bastien/configuration_file/nginx/service-loadbalancer.yaml

kubectl apply -f https://raw.githubusercontent.com/ISEN-Livefox/Livefox/bastien/configuration_file/namespaces.yaml
kubectl apply -f https://raw.githubusercontent.com/ISEN-Livefox/Livefox/bastien/configuration_file/metallb/metallb.yaml
kubectl create secret generic -n metallb-system memberlist --from-literal=secretkey="$(openssl rand -base64 128)"
