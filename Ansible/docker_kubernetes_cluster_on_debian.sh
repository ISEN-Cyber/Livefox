ansible-playbook -i inventory install_docker.yml -e ansible_sudo_pass=$1
ansible-playbook -i inventory installkube.yml -e ansible_sudo_pass=$1
ansible-playbook -i inventory change_docker_settings.yaml -e ansible_sudo_pass=$1
ansible-playbook -i inventory init_master.yml -e ansible_sudo_pass=$1
ansible-playbook -i inventory join_workers.yml -e ansible_sudo_pass=$1