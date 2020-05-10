ansible-playbook -i inventory installkube.yml -e ansible_sudo_pass=$1
ansible-playbook -i inventory init_master.yml -e ansible_sudo_pass=$1
ansible-playbook -i inventory join_workers.yml -e ansible_sudo_pass=$1