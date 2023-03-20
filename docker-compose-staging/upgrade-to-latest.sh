#!/bin/bash

echo "stop docker-compose ..."
docker-compose down

while true
do
    echo "Pulling latest docker-compose image..."
    docker-compose pull 

    if [ $? -eq 0 ]
    then
        echo "Docker Compose image successfully updated."
        break
    else
        echo "Failed to pull docker-compose image at $(date). Retrying in 10 seconds..."
        sleep 10
    fi
done

echo ""
echo "You can now start docker-compose using the following command:"
echo
echo "docker-compose up -d"
echo
