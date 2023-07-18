# aws-women-hello-api
Example java api, build image and push to ECR, deploy on EKS 

## Prerequisites

* Java 11
* Gradle 7
* Docker

## Build java app
```
sdk use java 11.0.19-tem

./gradlew clean build

```

## Build image

```
docker build -t manual-aws-women-hello-api:1.0.0 .

docker images
```

## Upload a image to ECR

1. Open the aws cli

2. Create the repository

* CONSOLA
* CLI

```
aws ecr create-repository \
    --repository-name manual-aws-women-hello-api:latest \
    --image-scanning-configuration scanOnPush=true \
    --region $AWS_REGION
```

3. Copy the uri

4. Tag image

```
docker tag manual-aws-women-hello-api:1.0.0 984724474376.dkr.ecr.us-east-2.amazonaws.com/manual-aws-women-hello-api:1.0.0

source ./credentials.sh

aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin 984724474376.dkr.ecr.us-east-2.amazonaws.com

docker push 984724474376.dkr.ecr.us-east-2.amazonaws.com/manual-aws-women-hello-api:1.0.0

docker rmi 984724474376.dkr.ecr.us-east-2.amazonaws.com/manual-aws-women-hello-api:1.0.0

```

## Deploy service and deployment
```
kubectl get nodes

kubectl create namespace aws-women

kubectl get namespace

kubectl config set-context --current --namespace=aws-women

kubectl apply -f deployment.yml

kubectl get deployment

kubectl get service

kubectl get pods

kubectl --namespace aws-women port-forward manual-aws-women-hello-api-5974fdd77f-sbsr7 8080:8080


http://localhost:8080/api/actuator/health

http://localhost:8080/api/v1/greet/Erika


helm uninstall aws-women-hello-api

kubectl get deployment

kubectl get pods

```


## Deploy app manually using helm-chart

```
kubectl get nodes

kubectl create namespace aws-women

kubectl get namespace

kubectl config set-context --current --namespace=aws-women

helm upgrade --install aws-women-hello-api helm-chart -f helm-chart/values.yaml

kubectl get pods

kubectl --namespace aws-women port-forward aws-women-hello-api-helm-chart-57c47cb4c7-gn4jd 8080:8080


http://localhost:8080/api/actuator/health

http://localhost:8080/api/v1/greet/Erika


helm uninstall aws-women-hello-api

kubectl get deployment

kubectl get pods

```


5. Ahora a automatizar esto

