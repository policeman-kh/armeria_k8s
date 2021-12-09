### Structure 
* Armeria
* Spring Boot
* Spring Boot Actuator

### Deploy and expose an app on k8s.
```
$ docker build -t armedia-k8s:test
$ kubectl apply -f k8s/deployment.yaml
$ kubectl expose deployment armeria-k8s --type=LoadBalancer
```
### Check a response
You can check a response from app with curl command.
```
$ curl http://localhost:8081/actuator/health
{"status":"UP","components":{"custom":{"status":"UP"},"diskSpace":{"status":"UP","details":{"total":62725623808,"free":41821859840,"threshold":10485760,"exists":true}},"livenessState":{"status":"UP"},"ping":{"status":"UP"},"readinessState":{"status":"UP"}},"groups":["liveness","readiness"]}
```

