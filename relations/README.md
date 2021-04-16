# Run with Docker

> docker pull python:3
> docker pull node:14
> docker pull tomcat:9-jre8-alpine

# Relational microservice

Port: 3000

## Make migrations

> yarn migrate

## Start server

> yarn start

## Test with curl

_Example_

> curl -X POST -H "Content-Type: application/json" -d @users_interests.json http://localhost:3000/users-interest
