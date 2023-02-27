#!/bin/bash

# Create timestamp
TIMESTAMP=$(date +%Y-%m-%d_%H-%M-%S)

# Create temp directory
TEMP_DIR=$(mktemp -d -t diagnostic_${TIMESTAMP}_XXXXXX)

# Get current date
DATE=$(date '+%Y-%m-%d')

# Define path for result file
RESULT_FILE="${TEMP_DIR}/system_info.txt"

# Check if required commands exist
for COMMAND in "tar" "rm" "df" "uname" "free"; do
    if ! command -v "${COMMAND}" > /dev/null; then
        echo "${COMMAND} command not found, cleaning up temp directory..."
        rm -rf "${TEMP_DIR}"
        exit 1
    fi
done

# Collect system information to result file
echo "Collecting system information..." > "${RESULT_FILE}"
echo "" >> "${RESULT_FILE}"
echo "Operating System information:" >> "${RESULT_FILE}"
uname -a >> "${RESULT_FILE}" 2>&1
echo "" >> "${RESULT_FILE}"
echo "Memory information:" >> "${RESULT_FILE}"
free -m >> "${RESULT_FILE}" 2>&1
echo "" >> "${RESULT_FILE}"
echo "Disk information:" >> "${RESULT_FILE}"
df -h >> "${RESULT_FILE}" 2>&1

# Get Docker and Docker-compose version
docker version > "${TEMP_DIR}/docker_version.txt" 2> "${TEMP_DIR}/docker_version_err.txt"
docker-compose version > "${TEMP_DIR}/docker_compose_version.txt" 2> "${TEMP_DIR}/docker_compose_version_err.txt"

# Get logs for each container
for container in $(docker-compose config --services); do
    docker logs "${container}" &> "${TEMP_DIR}/${container}_logs.txt" 
done

# Zip temp directory
ZIP_FILE="diagnostic_${TIMESTAMP}.zip"
zip -r "${ZIP_FILE}" "${TEMP_DIR}"

# Remove temp directory
rm -rf "${TEMP_DIR}"

