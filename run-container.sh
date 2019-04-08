#/bin/bash
echo "Run Container"
cd docker
docker-compose down -v
docker-compose -f "docker-compose.yml" up -d 