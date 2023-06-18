# java-springboot-mapconfig
java springboot mapconfig

## run docker command

this test map config app

```sh
docker run -d -p 31001:8090 --restart=always -v ${PWD}/application.properties:/application/application.properties  --name testapp wachira90/spring-test:dev1.0
```

##  application.properties

```application.properties
server.port=8090
spring.config.db.mysql=monavista-windows10
```

## test

```sh
http://localhost:8090/getdbconf
```

## yaml kubernet

```yml
apiVersion: v1
kind: ConfigMap
metadata:
  name: spring-configmap
  namespace: develop
  labels:
    app: spring-test1
data:
  application.properties: |-
    server.port=8090
    spring.config.db.mysql=wachira-kubenet-eks-config
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: dep-spring-config
  namespace: develop
  labels:
    app: spring-test1
spec:
  replicas: 1
  selector:
    matchLabels:
      app: spring-test1
  template:
    metadata:
      labels:
        app: spring-test1
    spec:
      containers:
      - name: spring-container
        image: wachira90/spring-test:dev1.0
        volumeMounts:
        - name: spring-configmap-pod
          mountPath: /application/application.properties
          subPath: application.properties
      volumes:
      - name: spring-configmap-pod
        configMap:
          name: spring-configmap
---
apiVersion: v1
kind: Service
metadata:
  name: spring-service
  namespace: develop
  labels:
    app: spring-test1
spec:
  type: NodePort
  selector:
    app: spring-test1
  ports:
    - port: 8090
      targetPort: 8090
      nodePort: 30090
```


