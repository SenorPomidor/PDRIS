#!/bin/bash

echo "Пулим..."

docker pull senorpomidor/pdris:random-number
docker pull senorpomidor/pdris:feign-client

echo "Запускаем..."

docker run -d -p 8080:8080 senorpomidor/pdris:random-number
docker run -d -p 8081:8081 senorpomidor/pdris:feign-client

echo "Готово!"
