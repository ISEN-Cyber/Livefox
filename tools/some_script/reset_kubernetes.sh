#!/bin/bash

kubectl drain $1 --delete-local-data --force --ignore-daemonsets
kubectl delete node $1
sudo -i
kubeadm reset
rm -r /etc/cni/net.d
iptables -F && iptables -t nat -F && iptables -t mangle -F && iptables -X
ipvsadm -C
exit
