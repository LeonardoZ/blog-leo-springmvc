#/bin/bash
echo "Build containers"
cd docker
docker-compose down -v
docker-compose -f "docker-compose.yml" build
