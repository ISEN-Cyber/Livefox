# Ansible to setup a kubernetes cluster

## First we need to setup a ssh connection to the machines

A good way to connect via ssh to a remote machine is to copy the public key of the machine that launch the ansible playbooks on the machine that will be part the cluster.

`ssh-keygen`

![](/images/ssh-keygen)

Then you can copy the id_rsa.pub into the `$HOME/.ssh/authorized_keys` file.

From the host machine to avoid the prompt for the first connection to a remote machine we can:

	ssh-keyscan -p <port> <ip> >> /root/.ssh/known_hosts



## We install ansible on our host machine

You can find the documentation to install ansible there: [Install Ansible](https://docs.ansible.com/ansible/latest/installation_guide/intro_installation.html)

## Download the repo Livefox

	git clone https://github.com/ISEN-Livefox/Livefox.git
	cd Livefox
	cd Ansible

## Modification needed on the files

You will have to modify the inventory file to match your configuration. Then according to this configuration modify the other files.
i.e Everything that is between "<>" must be changed, if you are not under a unix system you will have to modify somme paths such has  "/tmp/..."

## Install docker, kubernetes and setup cluster on debian

When you have modified the files you can launch the following to setup everything.

	./docker_kubernetes_cluster_on_debian.sh <sudo password for machine>

This will work only if all the machines have sudo installed and the users specified in the inventory file are in the sudoers (group sudo).

If you want to install it on another OS you will have to change the way you install docker according to the OS, and modify the package manager (apt here) depending on the OS in the ansible-playbooks.

## Install kubernetes and cluster only

Same as above you might need to change the package manager depending on the OS where you will run kubernetes.

	./install_k8s_cluster_for_debian_ubuntu.sh <sudo password for machine>

This will work only if all the machines have sudo installed and the users specified in the inventory file are in the sudoers (group sudo).
