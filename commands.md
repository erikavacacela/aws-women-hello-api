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
docker build -t aws-women-hello-api:latest .

docker images
```

# Upload a image to ECR

1. Open the aws cli

2. Create the repository

CONSOLA
CLI

```
aws ecr create-repository \
    --repository-name aws-women-hello-api:latest \
    --image-scanning-configuration scanOnPush=true \
    --region $AWS_REGION
```

3. Copy the uri

4. Tag image

```
docker tag aws-women-hello-api:latest 984724474376.dkr.ecr.us-east-2.amazonaws.com/aws-women-hello-api:1.0.0

source ./credentials.sh

aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin 984724474376.dkr.ecr.us-east-2.amazonaws.com

docker push 984724474376.dkr.ecr.us-east-2.amazonaws.com/aws-women-hello-api:1.0.0

docker rmi 984724474376.dkr.ecr.us-east-2.amazonaws.com/aws-women-hello-api:1.0.0

```

5. Ahora a automatizar esto