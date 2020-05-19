#!/bin/bash

sudo -i
chmod 0755 /etc/docker
curl https://raw.githubusercontent.com/ISEN-Livefox/Livefox/antoine/Ansible/docker_change_daemon.sh -o docker_change_daemon.sh
chmod +x docker_change_daemon.sh
./docker_change_daemon.sh
mkdir -p /etc/systemd/system/docker.service.d
systemctl daemon-reload
systemctl restart docker
exit
