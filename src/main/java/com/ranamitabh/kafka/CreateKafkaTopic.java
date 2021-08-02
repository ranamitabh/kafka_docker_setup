package com.ranamitabh.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class CreateKafkaTopic {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        AdminClient adminClient = AdminClient.create(properties);
        NewTopic newTopic = new NewTopic("test1", 1, (short)1); //new NewTopic(topicName, numPartitions, replicationFactor)

        List<NewTopic> newTopics = new ArrayList<NewTopic>();
        newTopics.add(newTopic);
        // Creating topic
        adminClient.createTopics(newTopics);
        adminClient.close();
    }
}
