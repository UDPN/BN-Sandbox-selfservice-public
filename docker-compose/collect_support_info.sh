#!/bin/bash

# Check OS type
if [[ "$OSTYPE" == "msys" || "$OSTYPE" == "win32" ]]; then
    OS_TYPE="windows"
else
    OS_TYPE="linux"
fi

# Create timestamp
TIMESTAMP=$(date +%Y-%m-%d_%H-%M-%S)

# Create temp directory
TEMP_DIR=$(mktemp -d -t diagnostic_${TIMESTAMP}_XXXXXX)

# Get system information
if [[ "$OS_TYPE" == "windows" ]]; then
    systeminfo > "${TEMP_DIR}/system_info.txt" 2> "${TEMP_DIR}/system_info_err.txt"
    wmic logicaldisk get size,freespace,caption > "${TEMP_DIR}/disk_info.txt" 2> "${TEMP_DIR}/disk_info_err.txt"
    wmic os get version > "${TEMP_DIR}/os_version.txt" 2> "${TEMP_DIR}/os_version_err.txt"
else
    free -h > "${TEMP_DIR}/memory_info.txt" 2> "${TEMP_DIR}/memory_info_err.txt"
    df -h > "${TEMP_DIR}/disk_info.txt" 2> "${TEMP_DIR}/disk_info_err.txt"
    lsb_release -a > "${TEMP_DIR}/os_version.txt" 2> "${TEMP_DIR}/os_version_err.txt"
fi

# Get Docker and Docker-compose version
docker version > "${TEMP_DIR}/docker_version.txt" 2> "${TEMP_DIR}/docker_version_err.txt"
docker-compose version > "${TEMP_DIR}/docker_compose_version.txt" 2> "${TEMP_DIR}/docker_compose_version_err.txt"

# Get logs for each container
for container in $(docker ps --format "{{.Names}}"); do
    docker logs "${container}" &> "${TEMP_DIR}/${container}_logs.txt" 
done

# Zip temp directory
ZIP_FILE="diagnostic_${TIMESTAMP}.zip"
zip -r "${ZIP_FILE}" "${TEMP_DIR}"

# Remove temp directory
rm -rf "${TEMP_DIR}"

