package com.kafka.pro;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Name;

public class Producer {

    public static void main(String[] args) {
        Properties pro = new Properties();
        // Setting properties
        pro.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        pro.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        pro.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "com.kafka.pro.DeveloperSerializer ");
        // creating object for producer
        KafkaProducer producer = new KafkaProducer(pro);
        // creating a record
        ProducerRecord<String, Developer> record = new ProducerRecord<String, Developer>("sai",
                new Developer("Mark", "dev", "KMC"));
        System.out.print(record.value().toString());
        producer.send(record);
        producer.flush();
        producer.close();
    }

}
