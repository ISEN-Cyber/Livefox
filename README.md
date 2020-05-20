Horizontal Pods Autoscaling
===

Step 1: Metrics server
---

To begin, you have to install a metrics server in your kubernetes cluster to recover data like the consumption of the cpu or the memory.

To do that, execute the following commands:

```
wget https://github.com/kubernetes-sigs/metrics-server/releases/download/v0.3.6/components.yaml
mv components.yaml metrics-server.yaml
```

You have to edit the metrics-server.yaml file.

```
vi metrics-server.yaml
```

Go down to deployment level, and replace it by:

```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: metrics-server
  namespace: kube-system
  labels:
    k8s-app: metrics-server
spec:
  selector:
    matchLabels:
      k8s-app: metrics-server
  template:
    metadata:
      name: metrics-server
      labels:
        k8s-app: metrics-server
    spec:
      serviceAccountName: metrics-server
      volumes:
      # mount in tmp so we can safely use from-scratch images and/or read-only containers
      - name: tmp-dir
        emptyDir: {}
      containers:
      - name: metrics-server
        image: k8s.gcr.io/metrics-server-amd64:v0.3.6
        imagePullPolicy: IfNotPresent
        args:
          - --cert-dir=/tmp
          - --secure-port=4443
          - --kubelet-preferred-address-types=InternalIP
          - --kubelet-insecure-tls
        ports:
        - name: main-port
          containerPort: 4443
          protocol: TCP
        securityContext:
          readOnlyRootFilesystem: true
          runAsNonRoot: true
          runAsUser: 1000
        volumeMounts:
        - name: tmp-dir
          mountPath: /tmp
      nodeSelector:
        kubernetes.io/os: linux
        kubernetes.io/arch: "amd64"
```

Now, look if your metrics-server run:

```
kubectl get pods --all-namespaces
```

Wait few seconds and try to type this command to look if your metrics-server is up.
```
kubectl top nodes
```

Step 2: Limit your deploy
---

We have to limit the use of cpu and memory.

if you type this command you can see the description od the deploy.
```
kubectl describe deploy livefox-deploy
```
