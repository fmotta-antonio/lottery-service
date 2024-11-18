#!make

docker-start:
	@echo "Docker start"
	@docker-compose --file scripts/docker-compose.yml up -d

docker-down:
	@echo "Docker down"
	@docker-compose --file scripts/docker-compose.yml down -v

