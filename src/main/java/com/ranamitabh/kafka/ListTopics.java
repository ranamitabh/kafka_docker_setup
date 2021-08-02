package com.ranamitabh.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class ListTopics {
    public static void main(String[] args) {
        Map<String, List<PartitionInfo>> topics;

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test-consumer-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");


        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
        topics = consumer.listTopics();
        System.out.println("topics list in kafka cluster are :"+topics);
        consumer.close();
    }
}
