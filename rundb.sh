#!/usr/bin/env bash

docker volume rm pgdata

docker volume create pgdata

docker run --name postgres -p 5432:5432 \
-e POSTGRES_PASSWORD=password -e POSTGRES_USER=root -e POSTGRES_DB=key-order \
-v pgdata:/var/lib/postgresql/data -d postgres:9.6
