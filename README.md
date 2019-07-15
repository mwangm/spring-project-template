Developer Portal -  Backend
------------

## Setup - Dev

### REQUIREMENTS
- JDK 1.8
- Docker

### Start DB
```
./rundb.sh
```
connect via bash
```
docker exec -it containerID bash
psql -U root -d key-order
```

### Run
```
./gradlew bootRun
```
