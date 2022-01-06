package com.kafka.pro;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class Consumer {

    public static void main(String[] args) {
        // Setting Properties
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "com.kafka.pro.DeveloperDeserializer");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG,"kafkaprop");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        //creating kafka consumer object
        KafkaConsumer<String, Developer> consumer = new KafkaConsumer<>(properties);

        //subscribing to the specific topic
        //kafka server sends a list of records so we get that in Array
        consumer.subscribe(Arrays.asList("sai"));

        while (true) {
            ConsumerRecords<String, Developer> records = consumer.poll(100);
            // we get the each record's object using for loop
            for (ConsumerRecord<String, Developer> record : records) {
                Developer value = record.value();
                System.out.println(value.toString());
            }

        }


    }
}