#!/bin/bash

docker network create mynetwork

echo "Пулим..."

docker pull senorpomidor/pdris:random-number
docker pull senorpomidor/pdris:feign-client

echo "Запускаем..."

docker run -d -p 8080:8080 --name random-number --network=mynetwork senorpomidor/pdris:random-number
docker run -d -p 8081:8081 --name feign-client --network=mynetwork senorpomidor/pdris:feign-client

echo "Готово!"
