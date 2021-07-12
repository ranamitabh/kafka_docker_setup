# kafka_docker_setup
POC on Kafka docker setup with a simple java producer consumer


Start docker-compose :
docker-compose up -d

Go to Kafka shell :
docker exec -it kafka /bin/sh

Create a topic :
./kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic test1

List a topic :
./kafka-topics.sh --list --zookeeper zookeeper:2181

Start producer :
./kafka-console-producer.sh --topic test1 --bootstrap-server localhost:9092

Start consumer :
./kafka-console-consumer.sh --topic test1 --from-beginning --bootstrap-server localhost:9092