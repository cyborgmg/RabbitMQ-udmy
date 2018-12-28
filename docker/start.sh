#!/bin/bash

docker-compose up -d

sleep 20

docker exec rabbitmq-management rabbitmqadmin -q import /rabbitconf.json