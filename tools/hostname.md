# Change the hostname

## Change the ingress

Your ingress.yaml find should have a host rule in which you specify the hostname of your application
(see below).

    apiVersion: networking.k8s.io/v1beta1
    kind: Ingress
    metadata:
      name: ingress-example
    spec:
      rules:
      - host: example.com
        http:
          paths:
          - path: /
            backend:
              serviceName: clientui-client
              servicePort: 8080

Once you have applied your ingress to your cluster, you can see if it worked:

    kubectl get ingress -n ingress-example

With this command, you will be able to see what ip address is used.

## Change the host file

You can then add it to your host file.
You can find this file at the path C:\Windows\System32\drivers\etc.

You will need to open your host file as an administrator, add it like :

    <ip-address>    example.com

You will now be able to access your web site using "example.com:port".

