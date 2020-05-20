Horizontal Pods Autoscaling
===

Step 1: Metrics server
---

To begin, you have to install a metrics server in your kubernetes cluster to recover data like the consumption of the cpu or the memory.
To do that:
```
kubectl apply -f https://github.com/ISEN-Livefox/Livefox/blob/theo/metrics-server.yaml
```
Or execute the following commands:

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
deploy metrics-server.yaml:
```
kubectl apply -f metrics-server.yaml
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

If you type this command you can see the description of the deploy.
```
kubectl describe deploy livefox-deploy
```
You have to edit livefox-deploy:
```
kubectl edit deploy livefox-deploy
```

Just after container write: ender `terminationMessagePolicy: File`
```
resources:
  limits:
    memory: "500Mi"
  requests:
    memory: "50Mi"
    cpu: "100m"
```

Step 3: deploy hpa
---

For the last step you have to deploy your horizontal pods autoscaler

```
kubectl create -f https://github.com/ISEN-Livefox/Livefox/blob/theo/hpa-cpu.yaml
kubectl create -f https://github.com/ISEN-Livefox/Livefox/blob/theo/hpa-memory.yaml
```

Now look if all run
```
watch kubectl get hpa,pods
```
