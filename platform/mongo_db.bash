[[ ! -a /usr/local/mongodb/data ]] && mkdir -p /usr/local/mongodb/data
docker run --name ct-mongo --network=ct-network -h mongodb -p 27017:27017 -d -v /usr/local/mongodb/data:/data/db -d mongo:latest
