SOURCE : https://www.youtube.com/watch?v=ei6fK9StzMM&t=257s

PART 1

kafka mac steps
Download from apache kafka website
Extract it
Go inside the extract and open terminal where bin, config folders exist

1st step : start zookeeper server
command to run in terminal
bin/zookeeper-server-start.sh config/zookeeper.properties 
this starts zookeeper which manages and maintains kafka clusters
keep it running

2nd step: start kafka server
start a new terminal , command to run in terminal
bin/kafka-server-start.sh config/server.properties
keep it running

Congrats Kafka is up and running


PART 2

Using kafka with console
1. create new kafka topic
2. produce message to topic using kafka console producer
3. consume message from topic using kafka console consumer


create new kafka topic:
start a new terminal and run the command , topic name is quickstart-events , provide kafka host and port
bin/kafka-topics.sh --create --topic quickstart-events --bootstrap-server localhost:9092
output : Created topic quickstart-events.
to describe the created topic
bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
Topic: quickstart-events	TopicId: 8JzfuSh5QE6_biHVoDerqw	PartitionCount: 1	ReplicationFactor: 1	Configs: 
	Topic: quickstart-events	Partition: 0	Leader: 0	Replicas: 0	Isr: 0	Elr: N/A	LastKnownElr: N/A

produce message to topic using kafka console producer:
run the command
bin/kafka-console-producer.sh --topic quickstart-events --bootstrap-server localhost:9092
This is my first event
This is my second event
we can now send messages to it and close it by ctrl + c, by default each line is a new message

consume message from topic using kafka console consumer
run the command
bin/kafka-console-consumer.sh --topic quickstart-events --from-beginning --bootstrap-server localhost:9092
this should show us a running program with messages we prduced

This is my first event
This is my second event

we can run both the producer and consumer in diff tabs and see the consumer reading data in realtime as produced by producer

--from-beginning means to read from beginning, if we just want to read new ones remove this
we can create 2 consumers and see that as well, data reflected in both


PART 3

Create 2 spring boot apps to produce and consumer message using kafka

2 services, deliveryboy and enduser, delivery boy sends location updates to kafka, end user receives the location updates
