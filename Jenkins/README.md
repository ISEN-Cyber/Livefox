# Jenkins with Github, Ansible running in docker

## Prerequisite

You need to have docker installed and running on your host machine.

## First we will setup Jenkins running in a docker container


	$ git clone https://github.com/ISEN-Livefox/Livefox.git
	$ cd Jenkins
	$ cd Jenkins_container
	$ docker image build -t <name for your jenkins container> .
	$ docker run -dit -p 8080:8080 -v /var/run/docker.sock:/var/run/docker.sock \
	--name <name for your container> <name of you image previously build> 
	
You can now access the jenkins ui via : http://127.0.0.1:8080

But you will need the admin password and you can get it with the following:

`docker exec jenkins-master cat /var/jenkins_home/secrets/initialAdminPassword`

You can now connect to jenkins as an admin.

A good practice would be to create multiple user with multiple access right but we will keep it simple for now.

So we continue as an admin.

If you want to access a private Github repository you will need to add credentials into jenkins.

You will create credentials of type Username+Password, in the username field put your github username and in the password field you will need to create a github token with the rights that you need.

We can now create our first pipeline.

## Deploy update with ansible and jenkins

	$ cd ..
	$ cd CentOS-Ansible-Container
	$ docker image build -t <name of your image> .
	$ docker run -d --name <name for ansible container> <name of your image>
	$ docker exec <name for ansible container> cat /root/.ssh/id_rsa.pub
	$ docker stop <name for ansible container>
	$ docker rm <name for ansible container>

You can now copy the id_rsa.pub into the remote machines($HOME/.ssh/authorized_keys) where you wish to deploy the updates with ansible.

`cd ../Jenkins-Ansible`

You will now modify everything that is between "<>" in the jenkinsfile to correspond to your needs, and modify the hosts file to be able to access the good machines, you will have to modify the playbook(update.yml) if the devices you want to update do not use "apt" as package manager.

When this is done, you can create a repo github and push the Jenkins-Ansible folder.

### Create the pipeline

Now go back to the Jenkins UI:

You create a new item>Multibranch Pipeline
	
You put your credentials if needed and the url for your github repo freshly created.

You can now start the pipeline and your systems should update.

The pipeline will automatically look for a jenkinsfile and execute is content if it is found.	
	