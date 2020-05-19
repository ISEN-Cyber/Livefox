# Upgrade control plane nodes

Follow this some steps to update your control plane nodes nodes. Execute the command in root user except command kubectl.

## Upgrade control plane nodes

Replace x in x-00 with the latest patch version.

    apt-mark unhold kubeadm kubelet kubectl && \
    apt-get update && apt-get install -y kubeadm=x-00 kubelet=x-00 kubectl=x-00 && \
    apt-mark hold kubeadm kubelet kubectl

    kubeadm version

Replace <cp-node-name> with the name of your control plane node

    kubectl drain <cp-node-name> --ignore-daemonsets

    kubeadm upgrade plan

Replace x by your version

    kubeadm upgrade apply vx

    kubectl uncordon <cp-node-name>

## Upgrade additional control plane nodes

    kubeadm upgrade node

    kubeadm upgrade apply

    apt-mark unhold kubelet kubectl && \
    apt-get update && apt-get install -y kubelet=x-00 kubectl=x-00 && \
    apt-mark hold kubelet kubectl

    systemctl restart kubelet

# Update worker nodes

Follow this some steps to update your worker nodes. Execute the command in root user except command kubectl.

    apt-mark unhold kubeadm && \
    apt-get update && apt-get install -y kubeadm=x-00 && \
    apt-mark hold kubeadm

Replace <node-to-drain> with the name of your control plane node.

    kubectl drain <node-to-drain> --ignore-daemonsets (from control plane nodes)

    sudo kubeadm upgrade node

Replace x in x with the latest patch version.

    apt-mark unhold kubelet kubectl && \
    apt-get update && apt-get install -y kubelet=x-00 kubectl=x-00 && \
    apt-mark hold kubelet kubectl

    systemctl restart kubelet

Replace <node-to-drain> with the name of your control plane node.

    kubectl uncordon <node-to-drain> (from control plane nodes)
