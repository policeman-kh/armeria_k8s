### How to create docker image.
```
$ docker build -t armedia-k8s:test
```
### How to deploy and expose a service on k8s.
```
$ kubectl apply -f k8s/deployment.yaml
$ kubectl expose deployment armeria-k8s --type=LoadBalancer
$ kubectl get services armeria-k8s
```
```
NAME          TYPE           CLUSTER-IP       EXTERNAL-IP   PORT(S)          AGE
armeria-k8s   LoadBalancer   10.102.216.200   localhost     8081:30273/TCP   6s
```
You can check a response from app with curl command.
```
$ curl http://localhost:8081/actuator/health
{"status":"UP","components":{"custom":{"status":"UP"},"diskSpace":{"status":"UP","details":{"total":62725623808,"free":41821859840,"threshold":10485760,"exists":true}},"livenessState":{"status":"UP"},"ping":{"status":"UP"},"readinessState":{"status":"UP"}},"groups":["liveness","readiness"]}
```

### How to clean a service on k8s.
```
$ kubectl delete services armeria-k8s
$ kubectl delete deployment armeria-k8s
```
